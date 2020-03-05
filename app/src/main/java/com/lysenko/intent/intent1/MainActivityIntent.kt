package com.lysenko.intent.intent1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main_intent.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.lysenko.R


class MainActivityIntent : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_intent)

        button_date.setOnClickListener (this)
        button_time.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        when(v){
//            button_time -> startActivity(Intent("android.intent.action.time"))
//            button_date -> startActivity(Intent("android.intent.action.date"))
        }
    }
}
