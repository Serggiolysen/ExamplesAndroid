package com.lysenko.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lysenko.R
import com.lysenko.retrofit.entity.CarResponse
import com.lysenko.retrofit.entity.Poi
import kotlinx.android.synthetic.main.activity_main5.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class Main5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://kiparo.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderApi = retrofit.create(JsonPlaseHlderApi::class.java)

        val call = jsonPlaceHolderApi.getPosts(3333.0, 342.0, 3242.0, 3453.0)

        call.enqueue(object : Callback<CarResponse> {
            override fun onFailure(call: Call<CarResponse>, t: Throwable) {
                textViewResult.setText("dsflsdkf")
            }

            override fun onResponse(call: Call<CarResponse>, response: Response<CarResponse>) {
//
                val posts = response.body()!!.poiList
                for (post in posts){
                    var content = ""
                    content+="coordinate: ${post.id}\n"
                    content+="fleeType: ${post.coordinate}\n"
                    content+="heading: ${post.fleeType}\n"
                    content+="id: ${post.heading}\n\n"

                    textViewResult.append(content)

                }
            }

        })
    }
}
