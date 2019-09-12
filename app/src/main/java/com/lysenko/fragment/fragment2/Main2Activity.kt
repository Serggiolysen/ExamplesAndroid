package com.lysenko.fragment.fragment2

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {

    lateinit var frag1: Fragment1
    lateinit var frag2: Fragment2
    lateinit var fragmentTrans: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        frag1 = Fragment1()
        frag2 = Fragment2()
        var chbStack = findViewById<CheckBox>(R.id.chbStack)
    }

    fun onClick(v: View) {
        fragmentTrans = supportFragmentManager.beginTransaction()
        if (v.id == R.id.btnAdd) {
            fragmentTrans.add(R.id.frgmCont, frag2)
            fragmentTrans.add(R.id.frgmCont, frag1)
        } else if (v.id == R.id.btnRemove) {
            fragmentTrans.remove(frag1)
        } else if (v.id == R.id.btnReplace) {
            fragmentTrans.replace(R.id.frgmCont, frag2)
        } else if (chbStack.isChecked) {
            fragmentTrans.addToBackStack(null)
        }
        fragmentTrans.commit()
    }
}
