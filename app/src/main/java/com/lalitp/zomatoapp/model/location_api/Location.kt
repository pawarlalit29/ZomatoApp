package com.lalitp.zomatoapp.model.location_api


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city_id")
    val cityId: Int,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("country_id")
    val countryId: Int,
    @SerializedName("country_name")
    val countryName: String,
    @SerializedName("entity_id")
    val entityId: Int,
    @SerializedName("entity_type")
    val entityType: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("title")
    val title: String
)