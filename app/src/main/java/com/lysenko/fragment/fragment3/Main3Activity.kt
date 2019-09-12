package com.lysenko.fragment.fragment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.lysenko.R

class Main3Activity : AppCompatActivity(), OnSomeEventListener {
    override fun someEvent(s: String) {
        val frag2=supportFragmentManager.findFragmentById(R.id.fragment1_activity_main3)
        frag2?.view?.findViewById<TextView>(R.id.textView_fr1)?.text="Text from Fragment 2: $s"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val f2 = Fragment2()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fragment2_activity_main3, f2)
        ft.commit()
    }

    fun onClick(v: View){
        val frag1 = supportFragmentManager.findFragmentById(R.id.fragment1_activity_main3)
        frag1?.view?.findViewById<TextView>(R.id.textView_fr1)?.text="Access to Fragment 1 from Activity"

        val frag2 = supportFragmentManager.findFragmentById(R.id.fragment2_activity_main3)
        frag2?.view?.findViewById<TextView>(R.id.textView_fr2)?.text="Access to Fragment 2 from Activity"
    }
}
