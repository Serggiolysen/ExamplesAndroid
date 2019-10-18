package com.lysenko.MVP.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("asr")
    val asr: String,
    @SerializedName("date_for")
    val dateFor: String,
    @SerializedName("dhuhr")
    val dhuhr: String,
    @SerializedName("fajr")
    val fajr: String,
    @SerializedName("isha")
    val isha: String,
    @SerializedName("maghrib")
    val maghrib: String,
    @SerializedName("shurooq")
    val shurooq: String
)