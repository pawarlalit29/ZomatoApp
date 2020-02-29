package com.lalitp.zomatoapp.model


import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("review")
    val review: List<Any?>?
)