package com.example.matchmate.activity;

import com.example.matchmate.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.matchmate.activity.Code
import com.hbb20.CountryCodePicker

class PhoneNum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_num)
        val countryCodePicker = findViewById<CountryCodePicker>(R.id.countryCodePicker)
        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            val intent = Intent(applicationContext, Code::class.java)
            startActivity(intent)
        }

//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String selectedCountryCode = countryCodePicker.getSelectedCountryCode();
//                String phoneNumber = editTextPhoneNumber.getText().toString().trim();
//
//                if (phoneNumber.isEmpty()) {
//                    Toast.makeText(PhoneNum.this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
//                } else {
//                    // Use selectedCountryCode and phoneNumber as needed
//                    String completePhoneNumber = "+" + selectedCountryCode + phoneNumber;
//                    Toast.makeText(PhoneNum.this, "Complete Phone Number: " + completePhoneNumber, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}