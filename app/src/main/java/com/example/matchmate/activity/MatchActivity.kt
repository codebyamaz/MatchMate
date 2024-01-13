package com.example.matchmate.activity;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.matchmate.R
import com.example.matchmate.fragment.Home
import com.example.matchmate.fragment.Likes
import com.example.matchmate.main.Main


class MatchActivity : AppCompatActivity() {

    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var matchText: TextView
    private lateinit var conversationText: TextView
    private lateinit var helloBtn: Button
    private lateinit var swipeBtn: Button
    private lateinit var cvOne: CardView
    private lateinit var cvTwo: CardView
    private lateinit var cvThree: CardView
    private lateinit var cvFour: CardView
    private lateinit var fl1: FrameLayout
    private lateinit var fl2: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        img3 = findViewById(R.id.img3)
        img4 = findViewById(R.id.img4)
        swipeBtn = findViewById(R.id.swipeButton)
        matchText = findViewById(R.id.matchText)
        conversationText = findViewById(R.id.convoText)
        helloBtn = findViewById(R.id.helloButton)
        cvFour = findViewById(R.id.cvFour)
        cvOne = findViewById(R.id.cvOne)
        cvTwo = findViewById(R.id.cvTwo)
        cvThree = findViewById(R.id.cvThree)
        fl1 = findViewById(R.id.fl1)
        fl2 = findViewById(R.id.fl2)

        val intent = intent.getIntExtra("MATCH_IMAGE", 0)
        img2.setImageResource(intent)

        swipeBtn.setOnClickListener {
            replaceFragment(Home())
        }
    }

    private fun replaceFragment(fragment: Fragment) {

//        val fragmentManager: FragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
//        fragmentTransaction.addToBackStack(null)
//        fragmentTransaction.commit()

        val intent = Intent(applicationContext, Main::class.java)
        intent.putExtra("KEY", R.drawable.g17)
        startActivity(intent)

    }
}
