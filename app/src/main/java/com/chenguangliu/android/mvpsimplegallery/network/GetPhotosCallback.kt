package com.chenguangliu.android.mvpsimplegallery.network

import com.chenguangliu.android.mvpsimplegallery.network.model.Photo

/**
 * Callback for get photos call
 */
interface GetPhotosCallback {

    /**
     * Called when the get photos call succeeds
     */
    fun onSuccess(photoList: List<Photo>)

    /**
     * Called when the get photos call fails
     */
    fun onFailure(error: Throwable)
}
