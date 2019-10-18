package com.lysenko.MVP.presenter

import com.lysenko.MVP.model.Item

interface ViewInterface {
    fun onDataCompleteFromApi (item: Item)
    fun onDataErrorFromApi (throwable: Throwable)
}