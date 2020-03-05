package com.lysenko.MVP.MVP1.presenter

import com.lysenko.MVP.MVP1.model.Item

interface ViewInterface {
    fun onDataCompleteFromApi (item: Item)
    fun onDataErrorFromApi (throwable: Throwable)
}