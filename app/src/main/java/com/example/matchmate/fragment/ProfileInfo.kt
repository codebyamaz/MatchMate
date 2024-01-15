package com.example.matchmate.fragment;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
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
        cv1 = view.findViewById(R.id.cardView11)
        cv2 = view.findViewById(R.id.cradView12)
        cv3 = view.findViewById(R.id.cardView13)
        cv4 = view.findViewById(R.id.cradView14)
        interest1 = view.findViewById(R.id.btn11)
        interest2 = view.findViewById(R.id.btn12)
        interest3 = view.findViewById(R.id.btn13)
        interest4 = view.findViewById(R.id.btn14)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameAge = view.findViewById(R.id.nameAge)

        val firstName = arguments?.getString("FIRST_NAME")
        val lastName = arguments?.getString("LAST_NAME")
        val btn1 = arguments?.getString("BTN")
        val btn2 = arguments?.getString("BTN2")
        val btn3 = arguments?.getString("BTN3")
        val btn4 = arguments?.getString("BTN4")
        val btn5 = arguments?.getString("BTN5")
        val btn6 = arguments?.getString("BTN6")
        val btn7 = arguments?.getString("BTN7")
        val btn8 = arguments?.getString("BTN8")
        val btn9 = arguments?.getString("BTN9")
        val btn10 = arguments?.getString("BTN10")
        val btn11 = arguments?.getString("BTN11")
        val btn12 = arguments?.getString("BTN12")
        val btn13 = arguments?.getString("BTN13")
        val btn14 = arguments?.getString("BTN14")

        interest1.text = btn1 ?: btn5 ?: btn9 ?: btn13 ?: ""
        interest2.text = btn2 ?: btn6 ?: btn10 ?: btn14 ?: ""
        interest3.text = btn3 ?: btn7 ?: btn11 ?: ""
        interest4.text = btn4 ?: btn8 ?: btn12 ?: ""

        if ( firstName != null && lastName != null ) {
            nameAge.text = "$firstName $lastName"
        } else {
            nameAge.text = "Hello there!"
        }
    }

}