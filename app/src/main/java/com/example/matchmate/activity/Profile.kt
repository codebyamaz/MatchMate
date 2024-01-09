package com.example.matchmate.activity;

import com.example.matchmate.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.matchmate.activity.Iam
import com.google.android.material.textfield.TextInputLayout

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val birthDate = findViewById<Button>(R.id.birthDate)
        val confirmation = findViewById<Button>(R.id.button4)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val firstName = findViewById<EditText>(R.id.editText5)
        val editText1 = findViewById<TextInputLayout>(R.id.editTexts)
        val editText2 = findViewById<TextInputLayout>(R.id.editTexts1)
        val LastName = findViewById<EditText>(R.id.editText6)
        val personImage = findViewById<ImageView>(R.id.imageView3)
        val relativeLayout = findViewById<RelativeLayout>(R.id.relative)
        birthDate.setOnClickListener {
            datePicker.visibility = View.VISIBLE
            firstName.visibility = View.INVISIBLE
            LastName.visibility = View.INVISIBLE
            birthDate.visibility = View.INVISIBLE
            personImage.visibility = View.INVISIBLE
            editText1.visibility = View.INVISIBLE
            editText2.visibility = View.INVISIBLE
        }
        relativeLayout.setOnClickListener {
            datePicker.visibility = View.INVISIBLE
            datePicker.visibility = View.INVISIBLE
            firstName.visibility = View.VISIBLE
            LastName.visibility = View.VISIBLE
            birthDate.visibility = View.VISIBLE
            personImage.visibility = View.VISIBLE
            editText1.visibility = View.VISIBLE
            editText2.visibility = View.VISIBLE
        }
        confirmation.setOnClickListener {
            val intent = Intent(applicationContext, Iam::class.java)
            startActivity(intent)
        }
    }
}