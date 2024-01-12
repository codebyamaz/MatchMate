package com.example.matchmate.activity;

import com.example.matchmate.R
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class Code : AppCompatActivity() {

    private lateinit var back: ImageView
    private lateinit var timer: TextView
    private lateinit var firstNum: EditText
    private lateinit var secondNum: EditText
    private lateinit var thirdNum: EditText
    private lateinit var fourthNum: EditText
    private lateinit var sendAgain: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_code)

        timer = findViewById(R.id.textView9)
        back = findViewById<ImageView>(R.id.backImage)
        sendAgain = findViewById<TextView>(R.id.sendagain)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint)
        firstNum = findViewById(R.id.editText)
        secondNum = findViewById(R.id.editText3)
        thirdNum = findViewById(R.id.editText2)
        fourthNum = findViewById(R.id.editText4)

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