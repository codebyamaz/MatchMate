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

    private var selectedInterestsCount = 0
    private var onClick = false
    private var selectedButton: Button? = null
    private var selectedButton2: Button? = null
    private var selectedButton3: Button? = null
    private var selectedButton4: Button? = null
    private var selectedButton5: Button? = null
    private var selectedButton6: Button? = null
    private var selectedButton7: Button? = null
    private var selectedButton8: Button? = null
    private var selectedButton9: Button? = null
    private var selectedButton10: Button? = null
    private var selectedButton11: Button? = null
    private var selectedButton12: Button? = null
    private var selectedButton13: Button? = null
    private var selectedButton14: Button? = null

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

    private lateinit var btn11: Button
    private lateinit var btn12: Button
    private lateinit var btn13: Button
    private lateinit var btn14: Button

    private lateinit var cv15: CardView
    private lateinit var cv16: CardView
    private lateinit var cv17: CardView
    private lateinit var cv18: CardView
    private lateinit var cv19: CardView
    private lateinit var cv20: CardView
    private lateinit var cv21: CardView
    private lateinit var cv22: CardView
    private lateinit var cv23: CardView
    private lateinit var cv24: CardView

    private lateinit var btn15: Button
    private lateinit var btn16: Button
    private lateinit var btn17: Button
    private lateinit var btn18: Button
    private lateinit var btn19: Button
    private lateinit var btn20: Button
    private lateinit var btn21: Button
    private lateinit var btn22: Button
    private lateinit var btn23: Button
    private lateinit var btn24: Button

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

    private lateinit var back: ImageView
    private lateinit var skip: TextView
    private lateinit var confirmation: Button
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var inflater2: LayoutInflater
    private lateinit var layout: View
    private lateinit var toastText: TextView
    private lateinit var customToast: Toast

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

        cv11 = findViewById(R.id.cardView11)
        cv12 = findViewById(R.id.cradView12)
        cv13 = findViewById(R.id.cardView13)
        cv14 = findViewById(R.id.cradView14)

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

        cv11.setOnClickListener(this)
        cv12.setOnClickListener(this)
        cv13.setOnClickListener(this)
        cv14.setOnClickListener(this)

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

        constraintLayout.setOnClickListener(this)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")

        confirmation.setOnClickListener {
            if ( selectedInterestsCount >= 4 ) {
                val intent = Intent(applicationContext, Main::class.java)

                if ( selectedButton == btn1 ) {
                    val btn1 = btn1.text
                    intent.putExtra("BTN", btn1)
                }

                if ( selectedButton2 == btn2 ) {
                    val btn2 = btn2.text
                    intent.putExtra("BTN2", btn2)
                }

                if (selectedButton3 == btn3) {
                    val btn3Text = btn3.text
                    intent.putExtra("BTN3", btn3Text)
                }

                if (selectedButton4 == btn4) {
                    val btn4Text = btn4.text
                    intent.putExtra("BTN4", btn4Text)
                }

                if (selectedButton5 == btn5) {
                    val btn5Text = btn5.text
                    intent.putExtra("BTN5", btn5Text)
                }

                if (selectedButton6 == btn6) {
                    val btn6Text = btn6.text
                    intent.putExtra("BTN6", btn6Text)
                }

                if (selectedButton7 == btn7) {
                    val btn7Text = btn7.text
                    intent.putExtra("BTN7", btn7Text)
                }

                if (selectedButton8 == btn8) {
                    val btn8Text = btn8.text
                    intent.putExtra("BTN8", btn8Text)
                }

                if (selectedButton9 == btn9) {
                    val btn9Text = btn9.text
                    intent.putExtra("BTN9", btn9Text)
                }

                if (selectedButton10 == btn10) {
                    val btn10Text = btn10.text
                    intent.putExtra("BTN10", btn10Text)
                }

                if (selectedButton11 == btn11) {
                    val btn11Text = btn11.text
                    intent.putExtra("BTN11", btn11Text)
                }

                if (selectedButton12 == btn12) {
                    val btn12Text = btn12.text
                    intent.putExtra("BTN12", btn12Text)
                }

                if (selectedButton13 == btn13) {
                    val btn13Text = btn13.text
                    intent.putExtra("BTN13", btn13Text)
                }

                if (selectedButton14 == btn14) {
                    val btn14Text = btn14.text
                    intent.putExtra("BTN14", btn14Text)
                }

                intent.putExtra("FIRST_NAME", firstName)
                intent.putExtra("LAST_NAME", lastName)

                startActivity(intent)

            } else {
                toastText.text = "Please select atleast 4 interests"
                customToast.view = layout
                customToast.duration = Toast.LENGTH_SHORT
                customToast.show()
            }
        }
    }

    override fun onClick(view: View) {
        val item = view.id
        when (item) {
            R.id.cv, R.id.btn1 -> {
                changeColor(cv1, btn1, R.drawable.mycamera2, btn1)
                selectedButton = btn1
            }
            R.id.cv2, R.id.btn2 -> {
                changeColor(cv2, btn2, R.drawable.shopping2, btn2)
                selectedButton2 = btn2
            }
            R.id.cvFour, R.id.btn3 -> {
                changeColor(cv3, btn3, R.drawable.my_voice2, btn3)
                selectedButton3 = btn3
            }
            R.id.cvThree, R.id.btn4 -> {
                changeColor(cv4, btn4, R.drawable.my_tennis2, btn4)
                selectedButton4 = btn4
            }
            R.id.cardView5, R.id.btn5 -> {
                changeColor(cv5, btn5, R.drawable.my_run2, btn5)
                selectedButton4 = btn5
            }
            R.id.cardView6, R.id.btn6 -> {
                changeColor(cv6, btn6, R.drawable.my_art2, btn6)
                selectedButton6 = btn6
            }
            R.id.cardView7, R.id.btn7 -> {
                changeColor(cv7, btn7, R.drawable.my_paragliding2, btn7)
                selectedButton7 = btn7
            }
            R.id.cardView8, R.id.btn8 -> {
                changeColor(cv8, btn8, R.drawable.investing2, btn8)
                selectedButton8 = btn8
            }
            R.id.cardView9, R.id.btn9 -> {
                changeColor(cv9, btn9, R.drawable.my_games2, btn9)
                selectedButton9 = btn9
            }
            R.id.cardView10, R.id.btn10 -> {
                changeColor(cv10, btn10, R.drawable.my_hiking2, btn10)
                selectedButton10 = btn10
            }
            R.id.cardView11, R.id.btn11 -> {
                changeColor(cv11, btn11, R.drawable.travel2, btn11)
                selectedButton11 = btn11
            }
            R.id.cradView12, R.id.btn12 -> {
                changeColor(cv12, btn12, R.drawable.books2, btn11)
                selectedButton12 = btn12
            }
            R.id.cardView13, R.id.btn13 -> {
                changeColor(cv13, btn13, R.drawable.music2, btn13)
                selectedButton13 = btn13
            }
            R.id.cradView14, R.id.btn14 ->  {
                changeColor(cv14, btn14, R.drawable.code2, btn14)
                selectedButton14 = btn14
            }
            R.id.constraint -> {
                changeColorTwo(cv1, btn1, R.drawable.mycamera)
                changeColorTwo(cv2, btn2, R.drawable.shopping)
                changeColorTwo(cv3, btn3, R.drawable.my_voice)
                changeColorTwo(cv4, btn4, R.drawable.my_tennis)
                changeColorTwo(cv5, btn5, R.drawable.run)
                changeColorTwo(cv6, btn6, R.drawable.my_art)
                changeColorTwo(cv7, btn7, R.drawable.my_paragliding)
                changeColorTwo(cv8, btn8, R.drawable.investing)
                changeColorTwo(cv9, btn9, R.drawable.my_games)
                changeColorTwo(cv10, btn10, R.drawable.my_hiking)
                changeColorTwo(cv11, btn11, R.drawable.travel)
                changeColorTwo(cv12, btn12, R.drawable.books)
                changeColorTwo(cv13, btn13, R.drawable.my_music)
                changeColorTwo(cv14, btn14, R.drawable.code)
            }
        }
    }

    private fun changeColor(cv: CardView, btn: Button, drawableId: Int, onClick: Button) {
        cv.setCardBackgroundColor(Color.parseColor("#E94057"))
        btn.setBackgroundColor(Color.parseColor("#E94057"))
        btn.setCompoundDrawablesWithIntrinsicBounds(drawableId, 0, 0, 0)
        btn.setTextColor(Color.WHITE)
        selectedInterestsCount++
    }

    private fun changeColorTwo(cv: CardView, btn: Button, drawableId: Int) {
        cv.setCardBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
        btn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
        btn.setCompoundDrawablesWithIntrinsicBounds(drawableId, 0, 0, 0)
        btn.setTextColor(Color.BLACK)
        selectedInterestsCount = 0
    }
}
