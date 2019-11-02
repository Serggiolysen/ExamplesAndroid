package com.lysenko.intent.intent1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_info.*
import java.text.SimpleDateFormat
import java.util.*

class InfoIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val action = intent.action
        var format = ""
        var textInfo = ""

        if (action.equals("android.intent.action.time")) {
            format = "HH:mm:ss"
            textInfo = "InfoIntent-1 Time:  "
        } else if (action.equals("android.intent.action.date")) {
            format = "dd:MM:yyyy"
            textInfo = "InfoIntent-1 Date:  "
        }

        var simpleDateFormat = SimpleDateFormat(format).format(Date(System.currentTimeMillis()))
        text_info_activity.setText(textInfo + simpleDateFormat)

    }
}
