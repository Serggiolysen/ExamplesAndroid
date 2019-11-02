package com.lysenko.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.TextView
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_main_service.view.*
import java.util.concurrent.TimeUnit

class MyService:Service() {

    override fun onCreate() {
        println("aaaa ----> onCreate service")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("aaaa ----> onStartCommand")

        someTask()
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onDestroy() {
        println("aaaa ---> onDestroy")
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    fun someTask(){
        Thread(Runnable {
            for (i in 1..5) {
                println("aaaa ---> i = $i")
                try {
                    TimeUnit.SECONDS.sleep(1)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
            stopSelf()
            println("aaaa ---> stopSelf")
        }).start()
    }



}