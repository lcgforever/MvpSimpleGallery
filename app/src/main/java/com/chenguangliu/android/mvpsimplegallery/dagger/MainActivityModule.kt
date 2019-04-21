package com.chenguangliu.android.mvpsimplegallery.dagger

import com.chenguangliu.android.mvpsimplegallery.CACHE_SIZE
import com.chenguangliu.android.mvpsimplegallery.dagger.annotation.ActivityScope
import com.chenguangliu.android.mvpsimplegallery.dagger.annotation.FragmentScope
import com.chenguangliu.android.mvpsimplegallery.main.FixedSizeCache
import com.chenguangliu.android.mvpsimplegallery.main.MainActivityContract
import com.chenguangliu.android.mvpsimplegallery.main.MainFragment
import com.chenguangliu.android.mvpsimplegallery.main.MainPresenter
import com.chenguangliu.android.mvpsimplegallery.network.model.Photo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Dagger module class for MainActivity dependencies
 */
@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun provideMainFragmentInjector(): MainFragment

    @ActivityScope
    @Binds
    abstract fun provideMainPresenter(mainPresenter: MainPresenter): MainActivityContract.PresenterContract

    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideDataCache(): FixedSizeCache<List<Photo>> {
            return FixedSizeCache(CACHE_SIZE)
        }
    }
}
