package com.lysenko.MVP.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lysenko.MVP.presenter.ViewInterface
import com.lysenko.MVP.model.Item
import com.lysenko.MVP.presenter.Presenter
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity(), ViewInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main4)

        Presenter(this).getDataFromApi("london")
    }

    override fun onDataCompleteFromApi(item: Item) {
        a1.setText(item.asr)
        a2.setText(item.dhuhr)
        a3.setText(item.fajr)
        a4.setText(item.isha)
        a5.setText(item.maghrib)
    }

    override fun onDataErrorFromApi(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }
}
