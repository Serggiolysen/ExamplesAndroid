package com.lysenko.handler

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_main_handler.*
import java.util.concurrent.TimeUnit


class MainActivityHandler : AppCompatActivity() {

    val LOG_TAG = "LOGG"
    private lateinit var handler: Handler



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_handler)

        handler = @SuppressLint("HandlerLeak")
        object : Handler() {
            override fun handleMessage(msg: android.os.Message) {
                // обновляем TextView
                tvInfo.text = "Закачано файлов: " + msg.what
                if (msg.what == 10) btnStart.isEnabled = true
            }
        }
     }

    fun onclick(v: View) {
        when (v) {
            btnStart -> {
                btnStart.isEnabled = false
                val t = Thread(Runnable {
                    for (i in 1..10) {
                        // долгий процесс
                        downloadFile()
                        handler.sendEmptyMessage(i)
                        // пишем лог
                        Log.d(LOG_TAG, "i = $i")
                    }
                })
                t.start()
            }
            btnTest -> Log.d(LOG_TAG, "test")
            else -> {
            }
        }
    }

    fun downloadFile() {
        // пауза - 1 секунда
        try {
            TimeUnit.MILLISECONDS.sleep(300)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
