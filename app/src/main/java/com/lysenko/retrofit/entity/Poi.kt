package com.lysenko.retrofit.entity

import com.google.gson.annotations.SerializedName


data class Poi(

    @SerializedName("id")
    val id: Int,

    @SerializedName("coordinate")
    val coordinate: Coordinate?,

    @SerializedName("fleetType")
    val fleeType: FleeType?,

    @SerializedName("heading")
    val heading: Double?



)