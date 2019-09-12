package com.lysenko.fragment.fragment4

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_main_4.*

class Main4: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_4)

        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.activity_main_fragment4_1, Fragment4_1())
//        transaction.add(R.id.activity_main_fragment4_2, Fragment4_2())
        transaction.replace(R.id.activity_main_fragment4_1, Fragment4_1())
        transaction.replace(R.id.activity_main_fragment4_2, Fragment4_2())
        transaction.commit()

        findViewById<View>(R.id.activity_main_fragment4_2).setOnClickListener {
            changefragment()
        }
    }

    private fun changefragment() {
        val transaction = supportFragmentManager.beginTransaction()
        val frag3 =Fragment4_3.getInstance("some_string")
        transaction.replace(R.id.activity_main_fragment4_1, frag3)
        transaction.addToBackStack(null)
        transaction.commit()

    }


}