package com.lalitp.zomatoapp.model.location_api


import com.google.gson.annotations.SerializedName
import com.lalitp.zomatoapp.model.Restaurant

data class LocationData(
    @SerializedName("location")
    val location: Location,
    @SerializedName("nearby_restaurants")
    val nearbyRestaurants: List<Restaurant>
)