package com.example.mykotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    lateinit var btnLog: Button;
    lateinit var btnReg: Button
    lateinit var edID: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edID = findViewById(R.id.edId)
        btnReg = findViewById(R.id.btnReg)
        btnLog = findViewById(R.id.btnLog)
        btnLog.setOnClickListener(View.OnClickListener {
            val inte = Intent(this, MainActivity::class.java)
            inte.putExtra("key", edID.text.toString())
            Log.e("TAG", "onCreate: " + edID.text.toString())
            startActivity(inte)
        })
        /*  btnReg.setOnClickListener(View.OnClickListener {

              val inte=Intent(this,RegisterActivity::class.java)
              inte.putExtra("key",edID.text)
              startActivity(inte)
          })*/

        btnReg.setOnClickListener {
            val inte = Intent(this, RegisterActivity::class.java)
            inte.putExtra("key", edID.text.toString())
            Log.e("TAG", "onCreate: " + edID.text.toString())
            startActivity(inte)
        }
    }
}