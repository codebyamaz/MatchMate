package com.example.matchmate.activity;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.matchmate.R


class Code : AppCompatActivity() {

    private lateinit var back: ImageView
    private lateinit var timer: TextView
    private lateinit var firstNum: EditText
    private lateinit var secondNum: EditText
    private lateinit var thirdNum: EditText
    private lateinit var fourthNum: EditText
    private lateinit var sendAgain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_code)

        timer = findViewById(R.id.textView9)
        back = findViewById<ImageView>(R.id.backImage)
        sendAgain = findViewById(R.id.sendagain)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint)
        firstNum = findViewById(R.id.edittext1)
        secondNum = findViewById(R.id.editttext2)
        thirdNum = findViewById(R.id.edittext3)
        fourthNum = findViewById(R.id.edittext4)

        firstNum.inputType = InputType.TYPE_CLASS_NUMBER
        secondNum.inputType = InputType.TYPE_CLASS_NUMBER
        thirdNum.inputType = InputType.TYPE_CLASS_NUMBER
        fourthNum.inputType = InputType.TYPE_CLASS_NUMBER

        constraintLayout.setOnClickListener {
            val intent = Intent(applicationContext, Profile::class.java)
            startActivity(intent)
        }

        sendAgain.setOnClickListener {
            val intent = Intent(applicationContext, Profile::class.java)
            startActivity(intent)
        }

        setEditTextListener(firstNum, secondNum)
        setEditTextListener(secondNum, thirdNum)
        setEditTextListener(thirdNum, fourthNum)
        setEditTextListener(fourthNum) {
            // This block is executed when the user presses Enter on the fourthNum
            val intent = Intent(applicationContext, Profile::class.java)
            startActivity(intent)
        }
    }

    private fun setEditTextListener(editText: EditText, nextEditText: EditText? = null, block: (() -> Unit)? = null) {
        editText.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)
            ) {
                nextEditText?.requestFocus()
                block?.invoke()
                return@setOnEditorActionListener true
            }
            false
        }
    }
}
