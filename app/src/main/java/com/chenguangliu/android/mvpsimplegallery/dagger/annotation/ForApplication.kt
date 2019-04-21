package com.chenguangliu.android.mvpsimplegallery.dagger.annotation

import javax.inject.Qualifier

/**
 * Custom qualifier annotation for application context
 */
@MustBeDocumented
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ForApplication
