package com.lysenko.retrofit

import com.lysenko.retrofit.entity.CarResponse
import com.lysenko.retrofit.entity.Poi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonPlaseHlderApi {
    @GET("t/fake-api/car-service.php")
    fun getPosts(
        @Query("p1Lat") p1Lat: Double,
        @Query("p1Lon") p1Lon: Double,
        @Query("p2Lat") p2Lat: Double,
        @Query("p2Lon") p2Lon: Double
    ): Call<CarResponse>

}