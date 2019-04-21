package com.chenguangliu.android.mvpsimplegallery

import com.chenguangliu.android.mvpsimplegallery.dagger.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Main application class
 */
class MvpSimpleGalleryApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }
}
