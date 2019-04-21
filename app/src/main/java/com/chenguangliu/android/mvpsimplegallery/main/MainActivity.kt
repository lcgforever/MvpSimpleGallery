package com.chenguangliu.android.mvpsimplegallery.main

import android.os.Bundle
import com.chenguangliu.android.mvpsimplegallery.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mainFragmentProvider: Provider<MainFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = supportFragmentManager.findFragmentById(R.id.mainActivityContainer)
        if (mainFragment == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.mainActivityContainer, mainFragmentProvider.get())
                .commit()
        }
    }
}
