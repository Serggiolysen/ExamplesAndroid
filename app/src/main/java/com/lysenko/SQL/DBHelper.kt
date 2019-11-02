package com.lysenko.SQL

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "contactDb"
        val TABLE_NAME = "contacts"

        val KEY_ID = "_id"
        val KEY_NAME = "name"
        val KEY_MAIL = "mail"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "create table " + TABLE_NAME + "(" + KEY_ID
                    + " integer primary key," + KEY_NAME + " text," + KEY_MAIL + " text" + ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists $TABLE_NAME")
        onCreate(db)
    }
}