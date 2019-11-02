package com.lysenko.service

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lysenko.R

class MainActivityService : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_service)

    }

    fun onClickStart(v: View) {
        println("aaaa ----> clickStart")
        startService(Intent(this, MyService::class.java))
    }

    fun onClickStop(v: View) {
        println("aaaa ---> clickStop")
        stopService(Intent(this, MyService::class.java))
    }
}