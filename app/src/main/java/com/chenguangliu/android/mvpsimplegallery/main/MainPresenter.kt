package com.chenguangliu.android.mvpsimplegallery.main

import android.content.SharedPreferences
import com.chenguangliu.android.mvpsimplegallery.PREF_CURRENT_PAGE_INDEX
import com.chenguangliu.android.mvpsimplegallery.dagger.annotation.ForApplication
import com.chenguangliu.android.mvpsimplegallery.network.GetPhotosCallback
import com.chenguangliu.android.mvpsimplegallery.network.model.Photo
import javax.inject.Inject
import javax.inject.Provider

/**
 * Main model implementation for [MainActivityContract.PresenterContract]
 */
class MainPresenter @Inject constructor(
    @ForApplication sharedPreferencesProvider: Provider<SharedPreferences>,
    mainModelProvider: Provider<MainModel>
) : MainActivityContract.PresenterContract {

    private val sharedPreferences by lazy { sharedPreferencesProvider.get() }
    private val mainModel by lazy { mainModelProvider.get() }
    private var view: MainActivityContract.ViewContract? = null
    private val getPhotosCallback by lazy {
        object : GetPhotosCallback {
            override fun onSuccess(photoList: List<Photo>) {
                view?.updatePhotoList(photoList)
            }

            override fun onFailure(error: Throwable) {
                view?.showLoadingError(error)
            }
        }
    }

    override fun attach(view: MainActivityContract.ViewContract) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    override fun onViewReady() {
        loadData()
    }

    override fun onRefresh() {
        loadData()
    }

    override fun onScrollToTop() {
        val newPageIndex = sharedPreferences.getInt(PREF_CURRENT_PAGE_INDEX, 0) - 1
        sharedPreferences.edit().putInt(PREF_CURRENT_PAGE_INDEX, newPageIndex).apply()
        mainModel.loadNewPhotos(newPageIndex, getPhotosCallback)
    }

    override fun onScrollToBottom() {
        val newPageIndex = sharedPreferences.getInt(PREF_CURRENT_PAGE_INDEX, 0) + 1
        sharedPreferences.edit().putInt(PREF_CURRENT_PAGE_INDEX, newPageIndex).apply()
        mainModel.loadNewPhotos(newPageIndex, getPhotosCallback)
    }

    private fun loadData() {
        mainModel.getRecentPhotos(getPhotosCallback)
    }
}
