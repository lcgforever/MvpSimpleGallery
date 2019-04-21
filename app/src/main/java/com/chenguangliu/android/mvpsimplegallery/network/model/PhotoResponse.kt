package com.chenguangliu.android.mvpsimplegallery.network.model

import com.google.gson.annotations.SerializedName

/**
 * Model class for photo network response
 */
data class PhotoResponse(@SerializedName("photos") val photos: Photos)
