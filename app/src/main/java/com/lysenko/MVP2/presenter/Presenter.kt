package com.lysenko.MVP2.presenter

import com.lysenko.MVP2.model.Poi
import com.lysenko.MVP2.model.PoiList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(viewInterface: ViewInterface) {

    val viewInterfaceThis =viewInterface

    fun getDataFromApi(p1Lat: Double,  p1Lon: Double, p2Lat: Double, p2Lon: Double) {

        RetrofitService.create()
            .detApi(p1Lat,  p1Lon, p2Lat, p2Lon)
            .enqueue(object : Callback<PoiList> {
                override fun onFailure(call: Call<PoiList>, t: Throwable) {
                    viewInterfaceThis.onDataErrorFromApi(t)
                    println("AAA ----> onFailure"  +t.message)

                }

                override fun onResponse(call: Call<PoiList>, response: Response<PoiList>) {
//                    println("AAA ----> onResponse "  + response.body()!!.poiLists)
                    viewInterfaceThis.onDataCompleteFromApi(response.body()!!.poiLists)
                }
            })
    }

}