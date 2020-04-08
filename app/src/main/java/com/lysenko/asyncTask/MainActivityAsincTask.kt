package com.lysenko.asyncTask

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_main_asink_task.*
import java.util.concurrent.TimeUnit


class MainActivityAsincTask : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_asink_task)

    }

    fun onclick(v: View) {
        MyTask().execute("file_path_1", "file_path_2", "file_path_3", "file_path_4")
    }

    internal inner class MyTask : AsyncTask<String, Int, Any>() {

        override fun onPreExecute() {
            super.onPreExecute()
            textViewInfo.setText("Begin onPreExecute")
        }

        override fun doInBackground(vararg params: String): Any? {
            showMess()
            try {
                var cnt = 0
                for (url in params) {
                    downloadFile(url)
                    // выводим промежуточные результаты
                    publishProgress(++cnt)
                }
                // разъединяемся
                TimeUnit.SECONDS.sleep(1)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return 1
        }

        override fun onPostExecute(result: Any?) {
            super.onPostExecute(result)
            textViewInfo.setText("End onPostExecute")
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            textViewInfo.setText("Downloaded " + values[0] + " files")
        }
    }

    @Throws(InterruptedException::class)
    private fun downloadFile(url: String) {
        TimeUnit.SECONDS.sleep(1)
    }

    fun showMess() {
        textViewInfo.setText("End doInBackground")
    }
}