package com.example.matchmate.fragment;

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.matchmate.R


class ProfileInfo : Fragment() {

    private lateinit var profilePic: ImageView
    private lateinit var back: ImageView
    private lateinit var profileScrollView: ScrollView
    private lateinit var nameAge: TextView
    private lateinit var send: ImageView
    private lateinit var occupation: TextView
    private lateinit var location: TextView
    private lateinit var awayDistance: Button
    private lateinit var about: TextView
    private lateinit var cv1: CardView
    private lateinit var cv2: CardView
    private lateinit var cv3: CardView
    private lateinit var cv4: CardView
    private lateinit var interest1 : Button
    private lateinit var interest2 : Button
    private lateinit var interest3 : Button
    private lateinit var interest4 : Button
    private lateinit var picture1: ImageView
    private lateinit var picture2: ImageView
    private lateinit var picture3: ImageView
    private lateinit var picture4: ImageView
    private lateinit var picture5: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_profile_info, container, false)

        profilePic = view.findViewById(R.id.profileInfoPicture)
        back = view.findViewById(R.id.backButtonTop)
        profileScrollView = view.findViewById(R.id.profileInfoPicScroll)
        nameAge = view.findViewById(R.id.nameAge)
        send = view.findViewById(R.id.sendButton)
        location = view.findViewById(R.id.location)
        awayDistance = view.findViewById(R.id.btn1)
        about = view.findViewById(R.id.aboutContent)
        occupation = view.findViewById(R.id.occupation)
        cv1 = view.findViewById(R.id.interest_1)
        cv2 = view.findViewById(R.id.interest_2)
        cv3 = view.findViewById(R.id.interest_3)
        cv4 = view.findViewById(R.id.interest_4)
        interest1 = view.findViewById(R.id.b1)
        interest2 = view.findViewById(R.id.b2)
        interest3 = view.findViewById(R.id.b3)
        interest4 = view.findViewById(R.id.b4)
        picture1 = view.findViewById(R.id.galleryPicture1)
        picture2 = view.findViewById(R.id.galleryPicture2)
        picture3 = view.findViewById(R.id.galleryPicture3)
        picture4 = view.findViewById(R.id.galleryPicture4)
        picture5 = view.findViewById(com.example.matchmate.R.id.galleryPicture5)

        val firstName = arguments?.getString("FIRST_NAME")
        val lastName = arguments?.getString("LAST_NAME")

        if (firstName != null) {
            nameAge.text = "$firstName $lastName"
        }

        return view
    }
}