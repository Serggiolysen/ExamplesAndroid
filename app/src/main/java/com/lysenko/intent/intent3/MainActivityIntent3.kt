package com.lysenko.intent.intent3

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.lysenko.R
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_intent3.*

class MainActivityIntent3 : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        var myIntent = Intent(this, NameActivityIntent::class.java)
        startActivityForResult(myIntent, 666)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_intent3)

        button2.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        textView2.text = "Your intent string: -> " + data.getStringExtra("gggg")
    }
}
