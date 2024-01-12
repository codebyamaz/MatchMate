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
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.matchmate.activity.Iam
import com.google.android.material.textfield.TextInputLayout

class Profile : AppCompatActivity() {

    private lateinit var skip: TextView
    private lateinit var mainImage: ImageView
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var birthDate: Button
    private lateinit var confirmation: Button
    private lateinit var datePicker: DatePicker
    private lateinit var editText1: TextInputLayout
    private lateinit var editText2: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        birthDate = findViewById<Button>(R.id.birthDate)
        confirmation = findViewById<Button>(R.id.button4)
        datePicker = findViewById<DatePicker>(R.id.datePicker)
        firstName = findViewById<EditText>(R.id.editText5)
        lastName = findViewById<EditText>(R.id.editText6)
        editText1 = findViewById<TextInputLayout>(R.id.editTexts)
        editText2 = findViewById<TextInputLayout>(R.id.editTexts1)
        mainImage = findViewById<ImageView>(R.id.imageView3)
        skip = findViewById(R.id.skip2)
        val relativeLayout = findViewById<RelativeLayout>(R.id.relative)

        birthDate.setOnClickListener {
            datePicker.visibility = View.VISIBLE
            firstName.visibility = View.INVISIBLE
            lastName.visibility = View.INVISIBLE
            birthDate.visibility = View.INVISIBLE
            mainImage.visibility = View.INVISIBLE
            editText1.visibility = View.INVISIBLE
            editText2.visibility = View.INVISIBLE
        }

        relativeLayout.setOnClickListener {
            datePicker.visibility = View.INVISIBLE
            datePicker.visibility = View.INVISIBLE
            firstName.visibility = View.VISIBLE
            lastName.visibility = View.VISIBLE
            birthDate.visibility = View.VISIBLE
            mainImage.visibility = View.VISIBLE
            editText1.visibility = View.VISIBLE
            editText2.visibility = View.VISIBLE
        }

        confirmation.setOnClickListener {
            val intent = Intent(applicationContext, Iam::class.java)
            startActivity(intent)
        }

    }
}