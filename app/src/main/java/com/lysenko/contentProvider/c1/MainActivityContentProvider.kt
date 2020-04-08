package com.lysenko.contentProvider.c1

import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_content_provider.*

class MainActivityContentProvider : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        fetchContact()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun fetchContact() {
        val contscts = arrayListOf<String>()

        val contentResolver = getContentResolver()

        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val selection = null
        val projection = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        )
        val selectionArgs = null
        val sortOrder = null

        val cursor = contentResolver.query(uri, projection, selectionArgs, sortOrder)

        while (cursor!!.moveToNext()) {
            val name =
                cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val number =
                cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

            contscts.add(name + "\n" + number)
        }

        listContact.adapter =
            ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, contscts)
    }
}