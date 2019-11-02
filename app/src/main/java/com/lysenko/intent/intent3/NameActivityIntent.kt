package com.lysenko.intent.intent3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.lysenko.R
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_name_intent.*

class NameActivityIntent : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_intent)

        b.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        setResult(Activity.RESULT_OK, Intent().putExtra("gggg", et.text.toString()))
        finish()
    }
}
