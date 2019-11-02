package com.lysenko.intent.intent2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_view_intent2.*

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_intent2)

        val intentMy = intent.extras
        for (i in intentMy!!.keySet()) {
            println("TAG  intent!!.keySet().item ---> " + i)
        }
        println("TAG  getStringExtra ---> " + intent.getStringExtra("gggg"))
        tw.text = intent.getStringExtra("gggg")
    }
}
