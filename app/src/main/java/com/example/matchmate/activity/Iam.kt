package com.example.matchmate.activity;

import com.example.matchmate.R
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.matchmate.fragment.ProfileInfo


class Iam : AppCompatActivity() {

    private lateinit var back: ImageView
    private lateinit var skip: TextView
    private lateinit var man: CardView
    private lateinit var woman: CardView
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_iam)

        woman = findViewById<CardView>(R.id.woman)
        man = findViewById<CardView>(R.id.man)
        back = findViewById<ImageView>(R.id.backImage)
        skip = findViewById(R.id.skip)
        submitButton = findViewById<Button>(R.id.submitButton)

        woman.setOnClickListener {
            woman.setBackgroundColor(Color.parseColor("#E94057"))
            man.setBackgroundColor(Color.WHITE)
        }


        man.setOnClickListener {
                woman.setBackgroundColor(Color.WHITE)
                man.setBackgroundColor(Color.parseColor("#E94057"))
            }

        submitButton.setOnClickListener {

            val firstName = intent.getStringExtra("FIRST_NAME")
            val lastName = intent.getStringExtra("LAST_NAME")
            val intent = Intent(applicationContext, Passions::class.java)

            intent.putExtra("FIRST_NAME", firstName)
            intent.putExtra("LAST_NAME", lastName)
            startActivity(intent)
            }

        }
}