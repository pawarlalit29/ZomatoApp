package com.lalitp.zomatoapp.model


import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("restaurant")
    val restaurant: RestaurantX?
)