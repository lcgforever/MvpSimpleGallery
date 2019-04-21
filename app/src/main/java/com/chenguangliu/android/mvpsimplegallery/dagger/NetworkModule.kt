package com.chenguangliu.android.mvpsimplegallery.dagger

import com.chenguangliu.android.mvpsimplegallery.dagger.annotation.ApiKey
import com.chenguangliu.android.mvpsimplegallery.network.PhotoHttpInterface
import com.chenguangliu.android.mvpsimplegallery.network.PhotoNetworkApi
import com.chenguangliu.android.mvpsimplegallery.network.PhotoNetworkClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.flickr.com/services/"
private const val API_KEY = "956848d86ca96e726111661eb0e3127d"

/**
 * Dagger module for network related dependencies
 */
@Module
abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun providePhotoNetworkApi(photoNetworkClient: PhotoNetworkClient): PhotoNetworkApi

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @JvmStatic
        @Provides
        @Singleton
        @ApiKey
        fun provideApiKey(): String {
            return API_KEY
        }

        @JvmStatic
        @Provides
        @Singleton
        fun providePhotoHttpInterface(retrofit: Retrofit): PhotoHttpInterface {
            return retrofit.create(PhotoHttpInterface::class.java)
        }
    }
}
