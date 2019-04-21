package com.chenguangliu.android.mvpsimplegallery.network

import com.chenguangliu.android.mvpsimplegallery.dagger.annotation.ApiKey
import com.chenguangliu.android.mvpsimplegallery.network.model.PhotoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Provider

private const val PER_PAGE_COUNT = 30

/**
 * Implementation for [PhotoNetworkApi] to get photos from backend
 */
class PhotoNetworkClient @Inject constructor(
    @ApiKey private val apiKey: String,
    photoHttpInterfaceProvider: Provider<PhotoHttpInterface>
) : PhotoNetworkApi {

    private val photoHttpInterface by lazy { photoHttpInterfaceProvider.get() }

    override fun getRecentPhotos(pageIndex: Int, callback: GetPhotosCallback) {
        val responseCallback = object : Callback<PhotoResponse> {
            override fun onResponse(call: Call<PhotoResponse>, response: Response<PhotoResponse>) {
                if (response.isSuccessful) {
                    callback.onSuccess(response.body()!!.photos.photoList)
                } else {
                    callback.onFailure(HttpException(response))
                }
            }

            override fun onFailure(call: Call<PhotoResponse>, t: Throwable) {
                callback.onFailure(t)
            }
        }
        photoHttpInterface
            .getRecentPhotos(apiKey, PER_PAGE_COUNT, pageIndex)
            .enqueue(responseCallback)
    }
}
