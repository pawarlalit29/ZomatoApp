package com.lalitp.zomatoapp.model


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("photo")
    val photo: PhotoX?
)