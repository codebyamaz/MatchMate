package com.example.matchmate.fragment;

import com.example.matchmate.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class Home : Fragment() {
    var backImg: ImageView? = null
    var filterImg: ImageView? = null
    var mainImg: ImageView? = null
    var dislikeImg: ImageView? = null
    var likeImg: ImageView? = null
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
        return view
    }
}