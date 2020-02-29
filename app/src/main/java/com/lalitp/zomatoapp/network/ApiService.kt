package com.lalitp.zomatoapp.network


import com.lalitp.zomatoapp.model.RestaurantData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface ApiService {
    @GET("search")
    @Headers("user-key:4feaa2167c4dc6beadf629319423bd4b")
    fun getRestaurant(@QueryMap hashMap: HashMap<String,String>): Observable<RestaurantData>

}