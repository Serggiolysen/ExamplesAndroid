package com.lysenko.MVP.presenter

import com.lysenko.MVP.model.DataSet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(viewInterface: ViewInterface) {

    val viewInterfaceThis =viewInterface

    fun getDataFromApi(city: String) {
        RetrofitService.create()
            .detApi(city)
            .enqueue(object : Callback<DataSet> {
                override fun onFailure(call: Call<DataSet>, t: Throwable) {
                    viewInterfaceThis.onDataErrorFromApi(t)
                }

                override fun onResponse(call: Call<DataSet>, response: Response<DataSet>) {
                    viewInterfaceThis.onDataCompleteFromApi(response.body()!!.items[0])
                }
            })
    }

}