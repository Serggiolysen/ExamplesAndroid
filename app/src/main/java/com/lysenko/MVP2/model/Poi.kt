package com.lysenko.MVP2.model


import com.google.gson.annotations.SerializedName

data class Poi(
    @SerializedName("coordinate")
    val coordinate: Coordinate,
    @SerializedName("fleetType")
    val fleetType: String,
    @SerializedName("heading")
    val heading: Double,
    @SerializedName("id")
    val id: Int
)