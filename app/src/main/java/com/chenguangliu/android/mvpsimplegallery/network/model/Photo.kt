package com.chenguangliu.android.mvpsimplegallery.network.model

import com.google.gson.annotations.SerializedName

/**
 * Model class for photo object
 */
data class Photo(
    @SerializedName("id") val id: String,
    @SerializedName("owner") val owner: String,
    @SerializedName("secret") val secret: String,
    @SerializedName("server") val server: String,
    @SerializedName("farm") val farm: Int,
    @SerializedName("title") val title: String,
    @SerializedName("ispublic") val isPublic: Int,
    @SerializedName("isfriend") val isFriend: Int,
    @SerializedName("isfamily") val isFamily: Int
) {

    fun getUrl(): String {
        return "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
    }

    fun isPublic(): Boolean {
        return isPublic.toBoolean()
    }

    fun isFriend(): Boolean {
        return isFriend.toBoolean()
    }

    fun isFamily(): Boolean {
        return isFamily.toBoolean()
    }

    private fun Int.toBoolean(): Boolean {
        return this != 0
    }
}
