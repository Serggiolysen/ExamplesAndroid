package com.lysenko.intent.intent4

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity;
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_color.*


class ColorActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        var myIntent = Intent()
        when(v){
            color_butt_red -> myIntent.putExtra("color", Color.RED)
            color_butt_blue -> myIntent.putExtra("color", Color.BLUE)
            color_butt_green -> myIntent.putExtra("color", Color.GREEN)
        }
        setResult(Activity.RESULT_OK, myIntent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        color_butt_red.setOnClickListener(this)
        color_butt_green.setOnClickListener(this)
        color_butt_blue.setOnClickListener(this)
    }

}
