package com.chenguangliu.android.mvpsimplegallery.dagger.annotation

import javax.inject.Qualifier

/**
 * Custom qualifier annotation for network call api key
 */
@MustBeDocumented
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApiKey
