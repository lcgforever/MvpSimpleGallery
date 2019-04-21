package com.chenguangliu.android.mvpsimplegallery.main

import com.chenguangliu.android.mvpsimplegallery.BasePresenter
import com.chenguangliu.android.mvpsimplegallery.network.GetPhotosCallback
import com.chenguangliu.android.mvpsimplegallery.network.model.Photo

/**
 * MVP contract for [MainActivity]
 */
interface MainActivityContract {

    interface PresenterContract : BasePresenter<ViewContract> {
        fun onViewReady()

        fun onRefresh()

        fun onScrollToTop()

        fun onScrollToBottom()
    }

    interface ModelContract {
        fun getRecentPhotos(callback: GetPhotosCallback)

        fun loadNewPhotos(direction: Direction, pageIndex: Int, callback: GetPhotosCallback)
    }

    interface ViewContract {
        fun updatePhotoList(photoList: List<Photo>)

        fun showLoadingError(error: Throwable)
    }
}
