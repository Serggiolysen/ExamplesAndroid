package com.lysenko.SQL

import android.app.TimePickerDialog
import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_main_sql.*


class MainActivitySQL : AppCompatActivity(), View.OnClickListener {

    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sql)

        addButt.setOnClickListener(this)
        readButt.setOnClickListener(this)
        clearButt.setOnClickListener(this)

        dbHelper = DBHelper(this)
    }

    override fun onClick(v: View?) {
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()

        val database = dbHelper.writableDatabase
        val contentValues = ContentValues()

        when (v) {
            addButt -> {
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_MAIL, email);
                database.insert(DBHelper.TABLE_NAME, null, contentValues);
                nameEditText.setText("")
                nameEditText.hint = "name"
                emailEditText.setText("")
                emailEditText.hint = "email"
            }

            readButt -> {
                val cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null, null)

                if (cursor.moveToFirst()) {
                    val idIndex = cursor.getColumnIndex(DBHelper.KEY_ID)
                    val nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME)
                    val emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL)
                    do {
                        resultTextView.text = "ID = " + cursor.getInt(idIndex) +
                                ", name = " + cursor.getString(nameIndex) +
                                ", email = " + cursor.getString(emailIndex)
                    } while (cursor.moveToNext())
                } else
                    resultTextView.text= "0 rows"
                cursor.close()
            }

            clearButt -> database.delete(DBHelper.TABLE_NAME, null, null);
        }

        dbHelper.close();
    }
}
