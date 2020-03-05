package com.lysenko._google_codelabs

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity;
import com.lysenko.R
import kotlinx.android.synthetic.main.activity_main_dice_roller.*
import java.util.*

class MainActivityDiceRoller : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dice_roller)
        result_text.text = getString(R.string.dicerolled)
        roll_button.setOnClickListener { rollDice() }
        countup_button.setOnClickListener { countUp() }

    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        result_text.text = randomInt.toString()
    }

    private fun countUp() {
        val tmpField = result_text.text.toString().toInt() + 1
        result_text.text = tmpField.toString()
    }
}
