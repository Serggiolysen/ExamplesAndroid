package com.lysenko.MVP2.presenter

import com.lysenko.MVP2.model.Poi


interface ViewInterface {
    fun onDataCompleteFromApi (poiList: List<Poi>)
    fun onDataErrorFromApi (throwable: Throwable)
}