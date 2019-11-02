package com.lysenko.intent.intent2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_main_intent2.*

class MainActivityIntent2 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_intent2)

        button.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        Toast.makeText(this, editText.text, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ViewActivity::class.java)
        intent.putExtra("gggg", editText.text.toString())
        startActivity(intent)
    }
}
