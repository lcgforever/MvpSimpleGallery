package com.chenguangliu.android.mvpsimplegallery.main

import com.chenguangliu.android.mvpsimplegallery.network.GetPhotosCallback
import com.chenguangliu.android.mvpsimplegallery.network.PhotoNetworkApi
import com.chenguangliu.android.mvpsimplegallery.network.model.Photo
import javax.inject.Inject
import javax.inject.Provider

/**
 * Main model implementation for [MainActivityContract.ModelContract]
 */
class MainModel @Inject constructor(
    photoNetworkApiProvider: Provider<PhotoNetworkApi>,
    dataCacheProvider: Provider<FixedSizeCache<List<Photo>>>
) : MainActivityContract.ModelContract {

    private val photoNetworkApi by lazy { photoNetworkApiProvider.get() }
    private val dataCache by lazy { dataCacheProvider.get() }

    override fun getRecentPhotos(callback: GetPhotosCallback) {
        photoNetworkApi.getRecentPhotos(0, object : GetPhotosCallback {
            override fun onSuccess(photoList: List<Photo>) {
                dataCache.put(Direction.END, photoList)
                callback.onSuccess(photoList)
            }

            override fun onFailure(error: Throwable) {
                callback.onFailure(error)
            }
        })
    }

    override fun loadNewPhotos(direction: Direction, pageIndex: Int, callback: GetPhotosCallback) {
        when (direction) {
            Direction.START -> {
                photoNetworkApi.getRecentPhotos(pageIndex, object : GetPhotosCallback {
                    override fun onSuccess(photoList: List<Photo>) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onFailure(error: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })
            }
            Direction.END -> {

            }
        }
    }
}
