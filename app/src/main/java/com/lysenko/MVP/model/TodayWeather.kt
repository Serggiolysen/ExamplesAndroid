package com.lysenko.MVP.model


import com.google.gson.annotations.SerializedName

data class TodayWeather(
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("temperature")
    val temperature: String
)