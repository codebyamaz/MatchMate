package com.example.matchmate.fragment;

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.matchmate.R
import com.example.matchmate.activity.MatchActivity


class Home : Fragment() {
    var backImg: ImageView? = null
    var filterImg: ImageView? = null
    private lateinit var mainImg: ImageView
    var dislikeImg: ImageView? = null
    private lateinit var likeImg: ImageView
    var starImg: ImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        backImg = view.findViewById<ImageView>(R.id.backImage)
        filterImg = view.findViewById<ImageView>(R.id.filterImage)
        mainImg = view.findViewById<ImageView>(R.id.mainPhoto)
        dislikeImg = view.findViewById<ImageView>(R.id.dislikeImage)
        likeImg = view.findViewById<ImageView>(R.id.likeImage)
        starImg = view.findViewById<ImageView>(R.id.starImage)

        likeImg.setOnClickListener {
            val imageResourceId: Int = com.example.matchmate.R.drawable.girl3

            val intent = Intent(context, MatchActivity::class.java)
            intent.putExtra("imageResourceId", imageResourceId)

            startActivity(intent)
        }

        return view
    }
}