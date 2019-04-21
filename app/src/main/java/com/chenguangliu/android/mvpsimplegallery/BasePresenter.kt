package com.chenguangliu.android.mvpsimplegallery

/**
 * Base presenter interface
 */
interface BasePresenter<T> {

    /**
     * Attach view to presenter
     */
    fun attach(view: T)

    /**
     * Detach presenter from its view
     */
    fun detach()
}
