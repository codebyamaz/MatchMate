package com.example.matchmate.main;

import com.example.matchmate.R
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dating.Messages
import com.example.matchmate.fragment.Home
import com.example.matchmate.fragment.Likes
import com.example.matchmate.fragment.ProfileInfo
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class Main : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private var firstName: String? = null
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: BottomNavigationView
    var homeFragment: Home = Home()
    var messageFragment = Messages()
    var likeFragment: Likes = Likes()
    var profileInfo: ProfileInfo = ProfileInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)

        frameLayout = findViewById<FrameLayout>(R.id.frameLayout)
        navigationView = findViewById<BottomNavigationView>(R.id.navBar)

        navigationView.setOnItemSelectedListener(this)
        navigationView.setSelectedItemId(R.id.main)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")

        intent.putExtra("FIRST_NAME", firstName)
        intent.putExtra("LAST_NAME", lastName)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment).commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.main) {

            val firstName = intent.getStringExtra("FIRST_NAME")
            val lastName = intent.getStringExtra("LAST_NAME")

            intent.putExtra("FIRST_NAME", firstName)
            intent.putExtra("LAST_NAME", lastName)

            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment).commit()
            return true
        }else if (id == R.id.like) {
            val firstName = intent.getStringExtra("FIRST_NAME")
            val lastName = intent.getStringExtra("LAST_NAME")

            intent.putExtra("FIRST_NAME", firstName)
            intent.putExtra("LAST_NAME", lastName)

            supportFragmentManager.beginTransaction().replace(frameLayout!!.id, likeFragment)
                .commit()
            return true
        } else if (id == R.id.message) {
            val firstName = intent.getStringExtra("FIRST_NAME")
            val lastName = intent.getStringExtra("LAST_NAME")

            intent.putExtra("FIRST_NAME", firstName)
            intent.putExtra("LAST_NAME", lastName)

            supportFragmentManager.beginTransaction().replace(frameLayout!!.id, messageFragment).commit()
            return true
        } else if (id == R.id.profile) {

            val firstName = intent.getStringExtra("FIRST_NAME")
            val lastName = intent.getStringExtra("LAST_NAME")
            val btn1 = intent.getStringExtra("BTN")
            val btn2 = intent.getStringExtra("BTN2")
            val btn3 = intent.getStringExtra("BTN3")
            val btn4 = intent.getStringExtra("BTN4")
            val btn5 = intent.getStringExtra("BTN5")
            val btn6 = intent.getStringExtra("BTN6")
            val btn7 = intent.getStringExtra("BTN7")
            val btn8 = intent.getStringExtra("BTN8")
            val btn9 = intent.getStringExtra("BTN9")
            val btn10 = intent.getStringExtra("BTN10")
            val btn11 = intent.getStringExtra("BTN11")
            val btn12 = intent.getStringExtra("BTN12")
            val btn13 = intent.getStringExtra("BTN13")
            val btn14 = intent.getStringExtra("BTN14")

            intent.putExtra("FIRST_NAME", firstName)
            intent.putExtra("LAST_NAME", lastName)
            intent.putExtra("BTN", btn1)
            intent.putExtra("BTN2", btn2)
            intent.putExtra("BTN3", btn3)
            intent.putExtra("BTN4", btn4)
            intent.putExtra("BTN5", btn5)
            intent.putExtra("BTN6", btn6)
            intent.putExtra("BTN7", btn7)
            intent.putExtra("BTN8", btn8)
            intent.putExtra("BTN9", btn9)
            intent.putExtra("BTN10", btn10)
            intent.putExtra("BTN11", btn11)
            intent.putExtra("BTN12", btn12)
            intent.putExtra("BTN13", btn13)
            intent.putExtra("BTN14", btn14)

            val profileInfoFragment = ProfileInfo()
            val args = Bundle()

            args.putString("FIRST_NAME", firstName)
            args.putString("LAST_NAME", lastName)
            args.putString("BTN", btn1)
            args.putString("BTN2", btn2)
            args.putString("BTN3", btn3)
            args.putString("BTN4", btn4)
            args.putString("BTN5", btn5)
            args.putString("BTN6", btn6)
            args.putString("BTN7", btn7)
            args.putString("BTN8", btn8)
            args.putString("BTN9", btn9)
            args.putString("BTN10", btn10)
            args.putString("BTN11", btn11)
            args.putString("BTN12", btn12)
            args.putString("BTN13", btn13)
            args.putString("BTN14", btn14)

            profileInfoFragment.arguments = args

            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, profileInfoFragment).commit()
            return true
        }
        return false
    }
}
