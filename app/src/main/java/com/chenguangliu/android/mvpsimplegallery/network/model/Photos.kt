package com.chenguangliu.android.mvpsimplegallery.network.model

import com.google.gson.annotations.SerializedName

/**
 * Model class for photos wrapper
 */
data class Photos(
    @SerializedName("page") val page: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("perpage") val countPerPage: Int,
    @SerializedName("total") val totalCount: Int,
    @SerializedName("photo") val photoList: List<Photo>,
    @SerializedName("stat") val status: String
)
