package com.lysenko.fragment.fragment4

import android.os.Bundle
import android.os.TestLooperManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.lysenko.R

class Fragment4_3 : Fragment() {

    companion object {
        private const val ID_KEY = "ID_KEY"

        fun getInstance(id: String): Fragment4_3 {
            val tempFragment = Fragment4_3()
            val bundle = Bundle()
            bundle.putString(ID_KEY, id)
            tempFragment.arguments = bundle
            return tempFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.activity_fragment_4_3, null)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewFr4_3 = view.findViewById<TextView>(R.id.textView_xml_fragment_4_3)
        textViewFr4_3.text = arguments?.getString(ID_KEY,"default value")
    }

}