package com.lysenko.fragment.fragment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lysenko.R


class MainActivity : AppCompatActivity() {

    val LOG_TAG = "AAA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fr)
        Log.d(LOG_TAG, "MainActivity onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "MainActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "MainActivity onDestroy")
    }
}
