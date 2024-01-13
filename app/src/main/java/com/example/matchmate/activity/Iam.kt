package com.example.matchmate.activity;

import com.example.matchmate.R
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
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
    private lateinit var inflater2: LayoutInflater
    private lateinit var layout: View
    private lateinit var toastText: TextView
    private lateinit var customToast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_iam)

        woman = findViewById<CardView>(R.id.woman)
        man = findViewById<CardView>(R.id.man)
        back = findViewById<ImageView>(R.id.backImage)
        skip = findViewById(R.id.skip)
        submitButton = findViewById<Button>(R.id.submitButton)

        customToast = Toast(applicationContext)
        inflater2 = layoutInflater
        layout = inflater2.inflate(R.layout.custom_toast_layout, findViewById(R.id.custom_toast_layout))
        toastText = layout.findViewById<TextView>(R.id.toastText)
        customToast.view = layout

        var isWoman= false
        var isMan = false

        woman.setOnClickListener {
            isWoman = true
            woman.setBackgroundColor(Color.parseColor("#E94057"))
            man.setBackgroundColor(Color.WHITE)
        }


        man.setOnClickListener {
                isMan = true
                woman.setBackgroundColor(Color.WHITE)
                man.setBackgroundColor(Color.parseColor("#E94057"))
            }

        submitButton.setOnClickListener {

            if ( isMan || isWoman ) {
                val firstName = intent.getStringExtra("FIRST_NAME")
                val lastName = intent.getStringExtra("LAST_NAME")
                val intent = Intent(applicationContext, Passions::class.java)

                intent.putExtra("FIRST_NAME", firstName)
                intent.putExtra("LAST_NAME", lastName)
                startActivity(intent)
            } else {
                toastText.text = "Please select your gender"
                customToast.view = layout
                customToast.duration = Toast.LENGTH_SHORT
                customToast.show()
            }

            }

        }
}