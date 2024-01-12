package com.example.matchmate.activity;

import com.example.matchmate.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.matchmate.activity.PhoneNum

class Signup : AppCompatActivity() {

    private lateinit var email: Button
    private lateinit var phoneNum: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        email = findViewById<Button>(R.id.button2);
        phoneNum = findViewById<Button>(R.id.button3)

        phoneNum.setOnClickListener {
            val intent = Intent(applicationContext, PhoneNum::class.java)
            startActivity(intent)
        }
    }
}