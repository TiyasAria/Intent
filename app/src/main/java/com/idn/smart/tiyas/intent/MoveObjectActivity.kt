package com.idn.smart.tiyas.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idn.smart.tiyas.intent.Model.Profile
import kotlinx.android.synthetic.main.activity_move_object.*
import kotlinx.android.synthetic.main.activity_move_with_data.*

class MoveObjectActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_PROFILE = "extra_profile"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_object)
        supportActionBar?.title = "Move Object"
        val objectProfile = intent.getParcelableExtra<Profile>(EXTRA_PROFILE) as Profile
        val finalObject = "Name : ${objectProfile.name}\nAge : ${objectProfile.age}\nPhone Number : ${objectProfile.phoneNUmber}\nAddress : ${objectProfile.address}\nEmail : ${objectProfile.email} "
        tv_object.text = finalObject
    }
}