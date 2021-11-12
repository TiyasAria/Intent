package com.idn.smart.tiyas.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.idn.smart.tiyas.intent.Model.Profile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    companion object {
        const val REQUEST_CODE = 110
    }
    //deklarasi
  //  var profile = Profile
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //untuk ganti judul gaes
        supportActionBar?.title = "Main"
        btn_to_activity.setOnClickListener(this)
        btn_data.setOnClickListener(this)
        btn_object.setOnClickListener(this)
        btn_call.setOnClickListener(this)
        btn_quiz.setOnClickListener(this)

//          jika tidak menggunkan view.onclicklistener diatas

//        btn_to_activity.setOnClickListener {
//            // mau ngapain yak, move to activity
//            // kalau di activity pakai this
//            //kalau di fragment pakainya context
//            val intentMove = Intent(this, MoveActivity::class.java)
//            startActivity(intentMove)
 //       }
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_to_activity -> {
                val intentMove = Intent(this, MoveActivity::class.java)
                startActivity(intentMove)
            }
            R.id.btn_data -> {
                val intentData = Intent(this,MoveWithDataActivity::class.java)
                intentData.putExtra(MoveWithDataActivity.EXTRA_NAME,"Tiyas Aria")
                intentData.putExtra(MoveWithDataActivity.EXTRA_NUMBER,18)
                startActivity(intentData)
            }
            R.id.btn_object -> {
                val profile = Profile("Tiyas Aria",
                    18,
                    6281329750536.0,
                    "Sragen tercintah",
                    "tiyasaria123@gmail.com")
                val intentObject = Intent(this,MoveObjectActivity::class.java)
                intentObject.putExtra(MoveObjectActivity.EXTRA_PROFILE,profile)
                startActivity(intentObject)
            }

            R.id.btn_call -> {
                val number = "082329067938"
                val intentCall = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number" ))
                startActivity(intentCall)
            }

            R.id.btn_quiz -> {
                val intentQuiz = Intent(this,QuizActivity::class.java)
                //startActivity(intentQuiz) ini untuk awal aaajjah selnjutnya di panggil berdasar data yg udah dibuat
                startActivityForResult(intentQuiz, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == QuizActivity.RESULT_CODE){
                val selectedValue = data?.getStringExtra(QuizActivity.SELECTED_VALUE)
                tv_result.text = "Makanan Favoritmu : $selectedValue"
            }
        }
    }
}