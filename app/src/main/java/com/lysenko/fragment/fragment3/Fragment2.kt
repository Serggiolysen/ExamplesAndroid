package com.lysenko.fragment.fragment3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_3_fr2.*

class Fragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_3_fr2, null)

        val btn = v.findViewById<Button>(R.id.button_activity_3_fr2)
        btn.setOnClickListener {
            activity?.findViewById<Button>(R.id.btnFind)?.text = "Access from Fragment2"
            Log.d("AAA", "Button click in Fragment2")
        }

        return v
    }

}