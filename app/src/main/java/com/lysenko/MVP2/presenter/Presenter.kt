package com.lysenko.MVP2.presenter

import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import com.lysenko.MVP2.model.PoiList

class Presenter(viewInterface: ViewInterface) {

    val viewInterfaceThis = viewInterface

    fun getDataFromApi(p1Lat: Double, p1Lon: Double, p2Lat: Double, p2Lon: Double) {

        RetrofitService.create()
            .detApi(p1Lat, p1Lon, p2Lat, p2Lon)
            .enqueue(object : Callback<PoiList> {
                override fun onFailure(call: Call<PoiList>, t: Throwable) {
                    viewInterfaceThis.onDataErrorFromApi(t)
                    println("AAA ----> onFailure" + t.message)
                }

                override fun onResponse(call: Call<PoiList>, response: Response<PoiList>) {
                    viewInterfaceThis.onDataCompleteFromApi(response.body()!!.poiLists)
                }
            })
    }
}