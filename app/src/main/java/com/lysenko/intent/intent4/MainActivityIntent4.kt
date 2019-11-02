package com.lysenko.intent.intent4

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_main_intent4.*

class MainActivityIntent4 : AppCompatActivity(), View.OnClickListener {

    private val COLOR_CODE = 1
    private val ALIGN_CODE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_intent4)

        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        uriButt.setOnClickListener(this)
        callButt.setOnClickListener(this)
        mapButt.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            button3 -> startActivityForResult(Intent(this, ColorActivity::class.java), COLOR_CODE)
            button4 -> startActivityForResult(Intent(this, AlignActivity::class.java), ALIGN_CODE)
            uriButt -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://tut.by")))
            mapButt -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("geo: 50.0, 50.0")))
            callButt -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("tel: 375295662808")))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("MyLog", "reqest code = " + requestCode + ", result code = " + resultCode)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                COLOR_CODE -> textView3.setTextColor(data!!.getIntExtra("color", Color.WHITE))
                ALIGN_CODE -> textView3.setGravity(data!!.getIntExtra("alignment", Gravity.LEFT))
            }
        }
    }
}
