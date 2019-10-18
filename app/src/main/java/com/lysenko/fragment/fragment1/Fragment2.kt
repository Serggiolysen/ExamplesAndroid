package com.lysenko.fragment.fragment1

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lysenko.R

class Fragment2 : Fragment() {


    val LOG_TAG = "AAA"

//    override fun onAttach(activity: Activity?) {
//        super.onAttach(activity)
//        Log.d(LOG_TAG, "Fragment2 onAttach")
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "Fragment2 onCreate")

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(LOG_TAG, "Fragment2 onCreateView")
        return inflater.inflate(R.layout.activity_fr2,null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(LOG_TAG, "Fragment2 onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "Fragment2 onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "Fragment2 onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "Fragment2 onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "Fragment2 onStop")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "Fragment2 onDestroyView")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "Fragment2 onDestroy")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LOG_TAG, "Fragment2 onDetach")

    }
}