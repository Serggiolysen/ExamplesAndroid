package com.lysenko.sharedpreferences
//
//import android.content.Context
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.Toast
//import com.lysenko.R
//import kotlinx.android.synthetic.main.activity_main.*
//
//class MainActivity : AppCompatActivity(), View.OnClickListener {
//
//    private val SAVED_TEXT = "saved_text"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
////
////        b1.setOnClickListener(this)
////        b2.setOnClickListener(this)
//
//        loadText()
//    }
//
//    override fun onClick(p0: View?) {
//        when (p0) {
//            b1 -> saveText()
//            b2 -> loadText()
//        }
//    }
//
//    fun saveText() {
//        val sPref = getSharedPreferences("MyFileWithPrefs", Context.MODE_PRIVATE)
//        val editor = sPref.edit()
//        editor.putString(SAVED_TEXT, et.text.toString())
//        editor.apply()
//        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
//    }
//
//    fun loadText() {
//        val sPref = getSharedPreferences("MyFileWithPrefs", Context.MODE_PRIVATE)
//        val savedText = sPref.getString(SAVED_TEXT, "")
//        et.setText(savedText)
//        Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        saveText()
//    }
//}
