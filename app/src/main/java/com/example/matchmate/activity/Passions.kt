package com.example.matchmate.activity;

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.matchmate.R
import com.example.matchmate.main.Main

class Passions : AppCompatActivity(), View.OnClickListener {

    private lateinit var cv1: CardView
    private lateinit var cv2: CardView
    private lateinit var cv3: CardView
    private lateinit var cv4: CardView
    private lateinit var cv5: CardView
    private lateinit var cv6: CardView
    private lateinit var cv7: CardView
    private lateinit var cv8: CardView
    private lateinit var cv9: CardView
    private lateinit var cv10: CardView
    private lateinit var cv11: CardView
    private lateinit var cv12: CardView
    private lateinit var cv13: CardView
    private lateinit var cv14: CardView

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn10: Button
    private lateinit var btn11: Button
    private lateinit var btn12: Button
    private lateinit var btn13: Button
    private lateinit var btn14: Button

    private lateinit var back: ImageView
    private lateinit var skip: TextView
    private lateinit var confirmation: Button
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var inflater2: LayoutInflater
    private lateinit var layout: View
    private lateinit var toastText: TextView
    private lateinit var customToast: Toast

    private var selectedInterestsCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passions)

        back = findViewById<ImageView>(R.id.backImage)
        skip = findViewById(R.id.skip)
        confirmation = findViewById<Button>(R.id.next)
        constraintLayout = findViewById(R.id.constraint)

        customToast = Toast(applicationContext)
        inflater2 = layoutInflater
        layout = inflater2.inflate(R.layout.custom_toast_layout, findViewById(R.id.custom_toast_layout))
        toastText = layout.findViewById<TextView>(R.id.toastText)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn10 = findViewById(R.id.btn10)
        btn11 = findViewById(R.id.btn11)
        btn12 = findViewById(R.id.btn12)
        btn13 = findViewById(R.id.btn13)
        btn14 = findViewById(R.id.btn14)

        cv1 = findViewById(R.id.cv)
        cv2 = findViewById(R.id.cv2)
        cv3 = findViewById(R.id.cvFour)
        cv4 = findViewById(R.id.cvThree)
        cv5 = findViewById(R.id.cardView5)
        cv6 = findViewById(R.id.cardView6)
        cv7 = findViewById(R.id.cardView7)
        cv8 = findViewById(R.id.cardView8)
        cv9 = findViewById(R.id.cardView9)
        cv10 = findViewById(R.id.cardView10)
        cv11 = findViewById(R.id.cardView11)
        cv12 = findViewById(R.id.cradView12)
        cv13 = findViewById(R.id.cardView13)
        cv14 = findViewById(R.id.cradView14)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn10.setOnClickListener(this)
        btn11.setOnClickListener(this)
        btn12.setOnClickListener(this)
        btn13.setOnClickListener(this)
        btn14.setOnClickListener(this)

        cv1.setOnClickListener(this)
        cv2.setOnClickListener(this)
        cv3.setOnClickListener(this)
        cv4.setOnClickListener(this)
        cv5.setOnClickListener(this)
        cv6.setOnClickListener(this)
        cv7.setOnClickListener(this)
        cv8.setOnClickListener(this)
        cv9.setOnClickListener(this)
        cv10.setOnClickListener(this)
        cv11.setOnClickListener(this)
        cv12.setOnClickListener(this)
        cv13.setOnClickListener(this)
        cv14.setOnClickListener(this)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")

        confirmation.setOnClickListener {
            if (selectedInterestsCount >= 0) {
                val intent = Intent(applicationContext, Main::class.java)

                if (btn1.isSelected) intent.putExtra("BTN", btn1.text)
                if (btn2.isSelected) intent.putExtra("BTN2", btn2.text)
                if (btn3.isSelected) intent.putExtra("BTN3", btn3.text)
                if (btn4.isSelected) intent.putExtra("BTN4", btn4.text)
                if (btn5.isSelected) intent.putExtra("BTN5", btn5.text)
                if (btn6.isSelected) intent.putExtra("BTN6", btn6.text)
                if (btn7.isSelected) intent.putExtra("BTN7", btn7.text)
                if (btn8.isSelected) intent.putExtra("BTN8", btn8.text)
                if (btn9.isSelected) intent.putExtra("BTN9", btn9.text)
                if (btn10.isSelected) intent.putExtra("BTN10", btn10.text)
                if (btn11.isSelected) intent.putExtra("BTN11", btn11.text)
                if (btn12.isSelected) intent.putExtra("BTN12", btn12.text)
                if (btn13.isSelected) intent.putExtra("BTN13", btn13.text)
                if (btn14.isSelected) intent.putExtra("BTN14", btn14.text)

                intent.putExtra("FIRST_NAME", firstName)
                intent.putExtra("LAST_NAME", lastName)

                startActivity(intent)
            } else {
//                toastText.text = "Please select at least 4 interests"
//                customToast.view = layout
//                customToast.duration = Toast.LENGTH_SHORT
//                customToast.show()
            }
        }

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.cv, R.id.btn1 -> changeColor(cv1, btn1, R.drawable.mycamera2, btn1)
            R.id.cv2, R.id.btn2 -> changeColor(cv2, btn2, R.drawable.shopping2, btn2)
            R.id.cvFour, R.id.btn3 -> changeColor(cv3, btn3, R.drawable.my_voice2, btn3)
            R.id.cvThree, R.id.btn4 -> changeColor(cv4, btn4, R.drawable.my_tennis2, btn4)
            R.id.cardView5, R.id.btn5 -> changeColor(cv5, btn5, R.drawable.my_run2, btn5)
            R.id.cardView6, R.id.btn6 -> changeColor(cv6, btn6, R.drawable.my_art2, btn6)
            R.id.cardView7, R.id.btn7 -> changeColor(cv7, btn7, R.drawable.my_paragliding2, btn7)
            R.id.cardView8, R.id.btn8 -> changeColor(cv8, btn8, R.drawable.investing2, btn8)
            R.id.cardView9, R.id.btn9 -> changeColor(cv9, btn9, R.drawable.my_games2, btn9)
            R.id.cardView10, R.id.btn10 -> changeColor(cv10, btn10, R.drawable.my_hiking2, btn10)
            R.id.cardView11, R.id.btn11 -> changeColor(cv11, btn11, R.drawable.travel2, btn11)
            R.id.cradView12, R.id.btn12 -> changeColor(cv12, btn12, R.drawable.books2, btn12)
            R.id.cardView13, R.id.btn13 -> changeColor(cv13, btn13, R.drawable.music2, btn13)
            R.id.cradView14, R.id.btn14 -> changeColor(cv14, btn14, R.drawable.code2, btn14)
        }
    }


    private fun changeColor(cv: CardView, btn: Button, drawableId: Int, onClick: Button) {
        cv.setCardBackgroundColor(Color.parseColor("#E94057"))
        btn.setBackgroundColor(Color.parseColor("#E94057"))
        btn.setCompoundDrawablesWithIntrinsicBounds(drawableId, 0, 0, 0)
        btn.setTextColor(Color.WHITE)
        selectedInterestsCount++
    }
}
