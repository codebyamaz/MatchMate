package com.example.matchmate.activity;

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.matchmate.R
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.time.Month
import java.util.GregorianCalendar
import java.util.Locale


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
    private lateinit var selectedBirthDate: Button
    var birthDateIsSelected: Boolean = false

    @RequiresApi(Build.VERSION_CODES.O)
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
        selectedBirthDate = findViewById(R.id.button5)
        skip = findViewById(R.id.skip2)
        val relativeLayout = findViewById<RelativeLayout>(R.id.relative)

        birthDate.setOnClickListener {
            birthDateIsSelected = true
            confirmation.visibility = View.INVISIBLE
            selectedBirthDate.visibility = View.VISIBLE
            datePicker.visibility = View.VISIBLE
            firstName.visibility = View.INVISIBLE
            lastName.visibility = View.INVISIBLE
            birthDate.visibility = View.INVISIBLE
            mainImage.visibility = View.INVISIBLE
            editText1.visibility = View.INVISIBLE
            editText2.visibility = View.INVISIBLE
        }

        var isDateFullySelected = false

        datePicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
            val isCompleteDateSelected = year != 0 && monthOfYear != -1 && dayOfMonth != 0

            if (isCompleteDateSelected) {
                isDateFullySelected = true

                val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
                val birthDateString = dateFormat.format(GregorianCalendar(year, monthOfYear, dayOfMonth).time)
                birthDate.text = birthDateString

            } else {
                isDateFullySelected = false
            }
        }

        selectedBirthDate.setOnClickListener {
            if (isDateFullySelected) {
                confirmation.visibility = View.VISIBLE
                selectedBirthDate.visibility = View.INVISIBLE
                datePicker.visibility = View.INVISIBLE
                firstName.visibility = View.VISIBLE
                lastName.visibility = View.VISIBLE
                birthDate.visibility = View.VISIBLE
                mainImage.visibility = View.VISIBLE
                editText1.visibility = View.VISIBLE
                editText2.visibility = View.VISIBLE
            }
        }

        confirmation.setOnClickListener {
            val firstNameText = firstName.text.toString()
            val lastNameText = lastName.text.toString()

            if (firstNameText.isNotEmpty() && lastNameText.isNotEmpty() && birthDateIsSelected) {
                // All fields are filled, proceed to the next activity

                val intent = Intent(applicationContext, Iam::class.java)
                intent.putExtra("FIRST_NAME", firstNameText)
                intent.putExtra("LAST_NAME", lastNameText)
                startActivity(intent)

            } else {

                val customToast = Toast(applicationContext)
                val inflater = layoutInflater
                val layout = inflater.inflate(R.layout.custom_toast_layout, findViewById(R.id.custom_toast_layout))
                val toastText = layout.findViewById<TextView>(R.id.toastText)

                if (firstNameText.isEmpty()) {
                    toastText.text = "Please enter your first name"
                } else if (lastNameText.isEmpty()) {
                    toastText.text = "Please enter your last name"
                } else if (!birthDateIsSelected) {
                    toastText.text = "Please select your birthdate"
                }

                customToast.view = layout
                customToast.duration = Toast.LENGTH_SHORT
                customToast.show()
            }
        }


    }
}