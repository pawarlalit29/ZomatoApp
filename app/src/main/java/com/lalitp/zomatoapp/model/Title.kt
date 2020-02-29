package com.lalitp.zomatoapp.model


import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("text")
    val text: String?
)