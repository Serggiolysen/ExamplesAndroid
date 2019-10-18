package com.lysenko.MVP2.presenter

import com.lysenko.MVP2.model.Poi
import com.lysenko.MVP2.model.PoiList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("t/fake-api/car-service.php")
    fun detApi(
        @Query("p1Lat") p1Lat: Double,
        @Query("p1Lon") p1Lon: Double,
        @Query("p2Lat") p2Lat: Double,
        @Query("p2Lon") p2Lon: Double
    ): Call<PoiList>

    companion object {
        fun create(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://kiparo.ru/")
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}