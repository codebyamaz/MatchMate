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
            supportFragmentManager.beginTransaction().replace(frameLayout!!.id, messageFragment).commit()
            return true
        } else if (id == R.id.profile) {

            val firstName = intent.getStringExtra("FIRST_NAME")
            val lastName = intent.getStringExtra("LAST_NAME")

            intent.putExtra("FIRST_NAME", firstName)
            intent.putExtra("LAST_NAME", lastName)

            val profileInfoFragment = ProfileInfo()
            val args = Bundle()

            args.putString("FIRST_NAME", firstName)
            args.putString("LAST_NAME", lastName)

            profileInfoFragment.arguments = args

            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, profileInfoFragment).commit()
            return true
        }
        return false
    }
}