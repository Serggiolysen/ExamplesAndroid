package com.lysenko.fragment.fragment3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_3_fr1.*
import android.app.Activity

class Fragment1 : Fragment() {

    lateinit var onSomeEventListener: OnSomeEventListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSomeEventListener = context as OnSomeEventListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_3_fr1, null)

        val btn = v.findViewById<Button>(R.id.button_activity_3_fr1)
        btn.setOnClickListener {

            onSomeEventListener.someEvent("Test text to Fragment1")
            activity?.findViewById<Button>(R.id.btnFind)?.text = "Access from Fragment1"
            Log.d("AAA", "Button click in Fragment1")
        }

        return v
    }
}