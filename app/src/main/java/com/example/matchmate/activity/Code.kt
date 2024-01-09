package com.example.matchmate.activity;

import com.example.matchmate.R
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class Code : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)
        val back = findViewById<ImageView>(R.id.backImage)
        val sendAgain = findViewById<TextView>(R.id.sendagain)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint)
        constraintLayout.setOnClickListener {
            val intent = Intent(applicationContext, Profile::class.java)
            startActivity(intent)
        }
        sendAgain.setOnClickListener {
            val intent = Intent(applicationContext, Profile::class.java)
            startActivity(intent)
        }
    }
}