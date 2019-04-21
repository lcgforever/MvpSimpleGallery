package com.chenguangliu.android.mvpsimplegallery.network

/**
 * Interface for photo network APIs
 */
interface PhotoNetworkApi {

    /**
     * API to get recent photos from backend
     */
    fun getRecentPhotos(pageIndex: Int, callback: GetPhotosCallback)
}
