package com.lalitp.zomatoapp.network

import com.lalitp.zomatoapp.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

    fun create(): ApiService {
        val retrofit: Retrofit = Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

}