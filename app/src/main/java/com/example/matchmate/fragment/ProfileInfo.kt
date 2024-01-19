package com.example.matchmate.fragment;

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
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

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_profile_info, container, false)

        sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        profilePic = view.findViewById(R.id.profileInfoPicture)
        back = view.findViewById(R.id.backButtonTop)
        profileScrollView = view.findViewById(R.id.profileInfoPicScroll)
        nameAge = view.findViewById(R.id.nameAge)
        send = view.findViewById(R.id.sendButton)
        location = view.findViewById(R.id.location)
        awayDistance = view.findViewById(R.id.btn1)
        about = view.findViewById(R.id.aboutContent)
//        occupation = view.findViewById(R.id.occupation)
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

//        send.setOnClickListener(View.OnClickListener { // When the sendButton is clicked, open the EditText
//            openEditText()
//        })

        // Set OnEditorActionListener for the occupationEditText

        // Set OnEditorActionListener for the occupationEditText
//        occupation.setOnEditorActionListener { _, actionId, event ->
//            if (actionId == EditorInfo.IME_ACTION_DONE ||
//                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)
//            ) {
//                Toast.makeText(requireContext(), "Helleo", Toast.LENGTH_SHORT).show()
//                return@setOnEditorActionListener true
//            }
//            false
//        }

        val firstName = arguments?.getString("FIRST_NAME")
        val lastName = arguments?.getString("LAST_NAME")

        if (firstName != null && lastName != null) {
            saveNameToSharedPreferences(firstName, lastName)
            nameAge.text = "$firstName $lastName"
        } else {
                nameAge.text = "Hello there!"
        }

        return view
    }

    private fun saveNameToSharedPreferences(firstName: String, lastName: String) {
        val editor = sharedPreferences.edit()
        editor.putString("FIRST_NAME", firstName)
        editor.putString("LAST_NAME", lastName)
        editor.apply()
    }

    private fun openEditText() {
        occupation.requestFocus()
    }

    // Method to update the resultTextView
    private fun updateResultTextView() {
        val enteredText: String = occupation.getText().toString().trim()
        location.setText(enteredText)
    }

}