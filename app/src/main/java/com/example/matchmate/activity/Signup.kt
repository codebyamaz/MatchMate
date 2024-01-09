package com.example.matchmate.activity;

import com.example.matchmate.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.matchmate.activity.PhoneNum

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val phoneNum = findViewById<Button>(R.id.button3)
        phoneNum.setOnClickListener {
            val intent = Intent(applicationContext, PhoneNum::class.java)
            startActivity(intent)
        }
    }
}