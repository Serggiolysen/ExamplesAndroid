package com.lysenko.MVP.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("{city}.json?key=65784636b1feaa6dd4cf0c876d069e90")
    fun detApi(@Path("city") city: String): Call<DataSet>

    companion object {
        fun create(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://muslimsalat.com/")
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}