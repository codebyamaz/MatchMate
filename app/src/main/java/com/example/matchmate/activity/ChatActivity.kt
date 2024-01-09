package com.example.matchmate.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.matchmate.R

class ChatActivity : AppCompatActivity() {
    var textView: TextView? = null
    var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat) // Use your app's R class

        textView = findViewById<TextView>(R.id.profile_name)
        imageView = findViewById<ImageView>(R.id.profile_image)

        val name = intent.getStringExtra("NAME_KEY")
        val imageResourceId = intent.getIntExtra("IMAGE_KEY", 0)

        textView?.text = name // Use ?. to safely call methods on nullable variables
        if (imageResourceId != 0) {
            imageView?.setImageResource(imageResourceId) // Use ?. to safely call methods on nullable variables
        }
    }
}
