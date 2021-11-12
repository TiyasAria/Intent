package com.idn.smart.tiyas.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    companion object{
        const val RESULT_CODE = 110
        const val SELECTED_VALUE = "selected_value"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        btn_submit.setOnClickListener{
            if (rg_quiz.checkedRadioButtonId != 0){
                var value = ""
                when(rg_quiz.checkedRadioButtonId) {
                    R.id.rd_ayam -> value = "Ayam"
                    R.id.rd_sapi -> value = "Sapi"
                    R.id.rd_sayur -> value = "Sayuran"
                    R.id.rd_buah -> value = "Buah-Buahan"
                }
                val resultValueIntent = Intent()
                resultValueIntent.putExtra(SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultValueIntent)
                finish()
            }
        }


    }
}