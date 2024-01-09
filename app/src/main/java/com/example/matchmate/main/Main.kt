package com.example.matchmate.main;

import com.example.matchmate.R
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.dating.Messages
import com.example.matchmate.fragment.Home
import com.example.matchmate.fragment.Likes
import com.example.matchmate.fragment.ProfileInfo
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class Main : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
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
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.main) {
            supportFragmentManager.beginTransaction().replace(frameLayout!!.id, homeFragment)
                .commit()
            return true
        } else if (id == R.id.like) {
            supportFragmentManager.beginTransaction().replace(frameLayout!!.id, likeFragment)
                .commit()
            return true
        } else if (id == R.id.message) {
            supportFragmentManager.beginTransaction().replace(frameLayout!!.id, messageFragment)
                .commit()
            return true
        } else if (id == R.id.profile) {
            supportFragmentManager.beginTransaction().replace(frameLayout!!.id, profileInfo)
                .commit()
            return true
        }
        return false
    }
}