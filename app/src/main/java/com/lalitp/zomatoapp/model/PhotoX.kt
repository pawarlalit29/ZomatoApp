package com.lalitp.zomatoapp.model


import com.google.gson.annotations.SerializedName

data class PhotoX(
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("friendly_time")
    val friendlyTime: String?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("res_id")
    val resId: Int?,
    @SerializedName("thumb_url")
    val thumbUrl: String?,
    @SerializedName("timestamp")
    val timestamp: Int?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("user")
    val user: User?,
    @SerializedName("width")
    val width: Int?
)