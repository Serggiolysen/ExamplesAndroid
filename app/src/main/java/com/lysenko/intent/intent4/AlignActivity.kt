package com.lysenko.intent.intent4

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity;
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_align.*


class AlignActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        var myIntent = Intent()
        when(v){
            color_butt_left -> myIntent.putExtra("alignment", Gravity.LEFT)
            color_butt_center -> myIntent.putExtra("alignment", Gravity.CENTER)
            color_butt_right -> myIntent.putExtra("alignment", Gravity.RIGHT)
        }
        setResult(Activity.RESULT_OK, myIntent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_align)

        color_butt_left.setOnClickListener(this)
        color_butt_right.setOnClickListener(this)
        color_butt_center.setOnClickListener(this)
    }

}
