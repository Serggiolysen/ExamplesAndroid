package com.lysenko.MVP2.view

import com.lysenko.R
import android.os.Bundle
import android.widget.Toast
import com.lysenko.MVP2.presenter.Presenter
import com.lysenko.MVP2.presenter.ViewInterface
import androidx.appcompat.app.AppCompatActivity
import com.lysenko.MVP2.model.Poi

class Main5Activity : AppCompatActivity(), ViewInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main4)

        println("AAA ----> onCreate")

        Presenter(this).getDataFromApi(66.0, 22.3, 66.0, 88.2)

    }

    override fun onDataCompleteFromApi(poiList: List<Poi>) {

        poiList.forEach {
            println("AAA ---------------------------------" )
            println("AAA ----> coordinate" + it.coordinate )
            println("AAA ----> fleetType" + it.fleetType )
            println("AAA ----> heading" + it.heading )
            println("AAA ----> id" + it.id )
        }
//        println("AAA ---->" + a1.setText(poi.coordinate.latitude.toString()))
//        println("AAA ---->" + a2.setText(poi.coordinate.longitude.toString()))
//        println("AAA ---->" + a3.setText(poi.fleetType.toString()))
//        println("AAA ---->" + a4.setText(poi.id))
//        println("AAA ---->" + a5.setText(poi.heading.toString()))


    }


    override fun onDataErrorFromApi(throwable: Throwable) {
        println("AAA ----> Main onError")

        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }
}
