package by.itacademy.pvtjune.dz.dz6

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.itacademy.myapplication.R
import kotlinx.android.synthetic.main.activity_edit_student_dz6.*
import java.util.regex.Pattern

class Dz6StudentEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student_dz6)
        val intent = Intent()

        save_button_activity_edit_dz6.setOnClickListener {
            val p = Pattern.compile("^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$")
            val m = p.matcher(urlEditText.text.toString())
            if (m.matches() && nameEditText.text != null && ageEditText.text.toString().toInt() > 16) {
                StudentsState.allStudents.add(
                    Student(
                        ++StudentsState.studentID,
                        urlEditText.text.toString(),
                        nameEditText.text.toString(),
                        ageEditText.text.toString().toInt()
                    )
                )
            } else if (!m.matches()) {
                Toast.makeText(this, "Check your data", Toast.LENGTH_SHORT).show()
            }
            println("AAA ---> m.matches() =${m.matches()},   allStudents --> ${StudentsState.allStudents}")


            intent.putExtra("JJJ", 111)
            

        }
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      