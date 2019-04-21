package com.chenguangliu.android.mvpsimplegallery.dagger

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.chenguangliu.android.mvpsimplegallery.dagger.annotation.ForApplication
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val TAG_SHARED_PREFERENCES = "TAG_SHARED_PREFERENCES"

/**
 * Application module class for app scope dependencies
 */
@Module
abstract class ApplicationModule {

    @Binds
    @Singleton
    @ForApplication
    abstract fun provideContext(application: Application): Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        @ForApplication
        fun provideSharedPreferences(@ForApplication context: Context): SharedPreferences {
            return context.getSharedPreferences(TAG_SHARED_PREFERENCES, Context.MODE_PRIVATE)
        }
    }
}
