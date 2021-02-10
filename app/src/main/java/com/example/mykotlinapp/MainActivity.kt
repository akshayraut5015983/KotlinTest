package com.example.mykotlinapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


@Suppress
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ss: String = intent.getStringExtra("key").toString()
        Log.e("TAG", "onCreate: "+ss )
        Toast.makeText(this, ss, Toast.LENGTH_LONG)
    }
}