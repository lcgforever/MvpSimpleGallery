package com.chenguangliu.android.mvpsimplegallery.network

import com.chenguangliu.android.mvpsimplegallery.network.model.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit photo API
 */
interface PhotoHttpInterface {

    @GET("rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1")
    fun getRecentPhotos(
        @Query("api_key") apiKey: String,
        @Query("per_page") countPerPage: Int,
        @Query("page") pageIndex: Int
    ): Call<PhotoResponse>
}
