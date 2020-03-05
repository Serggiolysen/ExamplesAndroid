package com.lysenko.MVP.MVP2.model


import com.google.gson.annotations.SerializedName

data class PoiList(
    @SerializedName("poiList")
    val poiLists: List<Poi>
)