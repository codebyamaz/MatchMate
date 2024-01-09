package com.example.matchmate.activity;

import com.example.matchmate.R
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Iam : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iam)
        val woman = findViewById<CardView>(R.id.woman)
        val man = findViewById<CardView>(R.id.man)
        val back = findViewById<ImageView>(R.id.backImage)
        val submit = findViewById<Button>(R.id.submitButton)
        woman.setOnClickListener {
            woman.setBackgroundColor(Color.parseColor("#E94057"))
            man.setBackgroundColor(Color.WHITE)
        }
        man.setOnClickListener {
            woman.setBackgroundColor(Color.WHITE)
            man.setBackgroundColor(Color.parseColor("#E94057"))
        }
        submit.setOnClickListener {
            val intent = Intent(applicationContext, Passions::class.java)
            startActivity(intent)
        }
    }
}