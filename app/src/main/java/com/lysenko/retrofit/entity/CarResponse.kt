package com.lysenko.retrofit.entity

import com.google.gson.annotations.SerializedName

data class CarResponse(

    @SerializedName("PoiList")
    val poiList: List<Poi>
)