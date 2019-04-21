package com.chenguangliu.android.mvpsimplegallery.dagger

import android.app.Application
import com.chenguangliu.android.mvpsimplegallery.MvpSimpleGalleryApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Application component class wrapping application scope dependencies
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MvpSimpleGalleryApplication> {

    // Component builder pattern
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): ApplicationComponent.Builder

        fun build(): ApplicationComponent
    }
}
