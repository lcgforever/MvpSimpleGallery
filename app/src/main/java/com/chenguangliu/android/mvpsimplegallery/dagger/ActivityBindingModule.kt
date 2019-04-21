package com.chenguangliu.android.mvpsimplegallery.dagger

import com.chenguangliu.android.mvpsimplegallery.dagger.annotation.ActivityScope
import com.chenguangliu.android.mvpsimplegallery.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Dagger module class defining all activity bindings
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun provideMainActivityInjector(): MainActivity
}
