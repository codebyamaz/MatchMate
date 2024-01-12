package com.example.matchmate.activity;

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passions)

        back = findViewById<ImageView>(R.id.backImage)
        skip = findViewById(R.id.skip)
        confirmation = findViewById<Button>(R.id.next)
        constraintLayout = findViewById(R.id.constraint)

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

        confirmation.setOnClickListener {
            val intent = Intent(applicationContext, Main::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(view: View) {
        val item = view.id
        when (item) {
            R.id.cv, R.id.btn1 -> changeColor(cv1, btn1, R.drawable.mycamera2)
            R.id.cv2, R.id.btn2 -> changeColor(cv2, btn2, R.drawable.shopping2)
            R.id.cvFour, R.id.btn3 -> changeColor(cv3, btn3, R.drawable.my_voice2)
            R.id.cvThree, R.id.btn4 -> changeColor(cv4, btn4, R.drawable.my_tennis2)
            R.id.cardView5, R.id.btn5 -> changeColor(cv5, btn5, R.drawable.my_run2)
            R.id.cardView6, R.id.btn6 -> changeColor(cv6, btn6, R.drawable.my_art2)
            R.id.cardView7, R.id.btn7 -> changeColor(cv7, btn7, R.drawable.my_paragliding2)
            R.id.cardView8, R.id.btn8 -> changeColor(cv8, btn8, R.drawable.my_music2)
            R.id.cardView9, R.id.btn9 -> changeColor(cv9, btn9, R.drawable.my_games2)
            R.id.cardView10, R.id.btn10 -> changeColor(cv10, btn10, R.drawable.my_hiking2)
            R.id.constraint -> {
                changeColorTwo(cv1, btn1, R.drawable.mycamera)
                changeColorTwo(cv2, btn2, R.drawable.shopping)
                changeColorTwo(cv3, btn3, R.drawable.my_voice)
                changeColorTwo(cv4, btn4, R.drawable.my_tennis)
                changeColorTwo(cv5, btn5, R.drawable.run)
                changeColorTwo(cv6, btn6, R.drawable.my_art)
                changeColorTwo(cv7, btn7, R.drawable.my_paragliding)
                changeColorTwo(cv8, btn8, R.drawable.my_music)
                changeColorTwo(cv9, btn9, R.drawable.my_games)
                changeColorTwo(cv10, btn10, R.drawable.my_hiking)
            }
        }
    }

    private fun changeColor(cv: CardView, btn: Button, drawableId: Int) {
        cv.setCardBackgroundColor(Color.parseColor("#E94057"))
        btn.setBackgroundColor(Color.parseColor("#E94057"))
        btn.setCompoundDrawablesWithIntrinsicBounds(drawableId, 0, 0, 0)
        btn.setTextColor(Color.WHITE)
    }

    private fun changeColorTwo(cv: CardView, btn: Button, drawableId: Int) {
        cv.setCardBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
        btn.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
        btn.setCompoundDrawablesWithIntrinsicBounds(drawableId, 0, 0, 0)
        btn.setTextColor(Color.BLACK)
    }
}
