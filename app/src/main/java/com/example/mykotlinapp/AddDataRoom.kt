package com.example.mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.Button
import android.widget.EditText

class AddDataRoom : AppCompatActivity() {
    lateinit var name: EditText;
    lateinit var email: EditText;
    lateinit var pass: EditText;

    private lateinit var mode: Display.Mode

    private var noteId: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data_room)
        findViewById<Button>(R.id.btnSub).setOnClickListener {
            val strname: String = name.text.toString()
            val stremail: String = email.text.toString()
            val strpass: String = pass.text.toString()

        }
    }
}