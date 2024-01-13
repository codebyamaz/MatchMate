package com.example.matchmate.main

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.dating.Messages
import com.example.matchmate.R
import com.example.matchmate.fragment.Home
import com.example.matchmate.fragment.Likes
import com.example.matchmate.fragment.ProfileInfo
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class Main : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var frameLayout: FrameLayout
    private lateinit var navigationView: BottomNavigationView

    private val homeFragment = Home()
    private val messageFragment = Messages()
    private val likeFragment = Likes()
    private val profileInfoFragment = ProfileInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        frameLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navBar)

        navigationView.setOnItemSelectedListener(this)
        navigationView.setSelectedItemId(R.id.main)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")

        val args = Bundle().apply {
            putString("FIRST_NAME", firstName)
            putString("LAST_NAME", lastName)
        }

        profileInfoFragment.arguments = args

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.main -> {
                val firstName = intent.getStringExtra("FIRST_NAME")
                val lastName = intent.getStringExtra("LAST_NAME")

                val args = Bundle().apply {
                    putString("FIRST_NAME", firstName)
                    putString("LAST_NAME", lastName)
                }

                profileInfoFragment.arguments = args

                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment).commit()
            }
            R.id.like -> supportFragmentManager.beginTransaction().replace(frameLayout.id, likeFragment).commit()
            R.id.message -> supportFragmentManager.beginTransaction().replace(frameLayout.id, messageFragment).commit()
            R.id.profile -> {
                val firstName = intent.getStringExtra("FIRST_NAME")
                val lastName = intent.getStringExtra("LAST_NAME")

                val args = Bundle().apply {
                    putString("FIRST_NAME", firstName)
                    putString("LAST_NAME", lastName)
                }

                profileInfoFragment.arguments = args

                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, profileInfoFragment).commit()
            }
        }
        return true
    }
}
