package com.example.matchmate.main;

import com.example.matchmate.R
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.matchmate.activity.Signup

class MainActivity : AppCompatActivity() {

    private lateinit var createAcc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        createAcc = findViewById<Button>(R.id.button)

        val text = "Already have an account? Sign In"
        val spannable: Spannable = SpannableString(text)
        val startIndex = text.indexOf("Sign In")

        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#E94057")),
            startIndex,
            startIndex + "Sign In".length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        createAcc.setOnClickListener {
            val intent = Intent(applicationContext, Signup::class.java)
            startActivity(intent)
        }

    }
}