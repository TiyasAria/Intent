package com.idn.smart.tiyas.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_move_with_data.*

class MoveWithDataActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_NUMBER = "extra_number"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)
        supportActionBar?.title = "Move data"
        val name = intent.getStringExtra(EXTRA_NAME)
        val number = intent.getIntExtra(EXTRA_NUMBER,0)
        val finalData = "Name : $name\nAge : $number"
        tv_data.text = finalData
    }
}