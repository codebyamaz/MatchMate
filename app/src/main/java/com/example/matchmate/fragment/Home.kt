package com.example.matchmate.fragment

import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.matchmate.R
import com.example.matchmate.adapter.ImageAdapter
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import kotlin.properties.Delegates

class Home : Fragment() {

    private var currentImageIndex by Delegates.notNull<Int>()
    private lateinit var backImg: ImageView
    private lateinit var filterImg: ImageView
    private lateinit var dislikeImg: ImageView
    private lateinit var likeImg: ImageView
    private lateinit var starImg: ImageView
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var flingAdapterView: SwipeFlingAdapterView
    private lateinit var toastText: TextView
    private lateinit var customToast: Toast
    private lateinit var layout: View
    private lateinit var frameLayout: FrameLayout
    private var canSwipe = true

    private var initialData = mutableListOf(
        R.drawable.g29, R.drawable.girl7, R.drawable.g23, R.drawable.g27, R.drawable.g20,
        R.drawable.g36, R.drawable.g22, R.drawable.g17, R.drawable.girl20, R.drawable.g26,
        R.drawable.g13, R.drawable.g18, R.drawable.g19, R.drawable.g11, R.drawable.g21,
        R.drawable.g15, R.drawable.g24, R.drawable.girl19, R.drawable.g25, R.drawable.girl17,
        R.drawable.girl9, R.drawable.girl15, R.drawable.girl2, R.drawable.girl14, R.drawable.g1,
        R.drawable.g30, R.drawable.g32, R.drawable.g16, R.drawable.g35, R.drawable.girl13, R.drawable.girl5
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        backImg = view.findViewById(R.id.backImage)
        filterImg = view.findViewById(R.id.filterImage)
        dislikeImg = view.findViewById(R.id.dislikeImage)
        likeImg = view.findViewById(R.id.likeImage)
        starImg = view.findViewById(R.id.starImage)
        flingAdapterView = view.findViewById(R.id.swipe)
        frameLayout = view.findViewById(R.id.mainPhoto)
        customToast = Toast(context)
        layout = inflater.inflate(R.layout.custom_toast_layout, view.findViewById(R.id.custom_toast_layout))
        toastText = layout.findViewById<TextView>(R.id.toastText)

        currentImageIndex = 0
        setupFlingAdapter()

        likeImg.setOnClickListener {
            handleSwipe(true)
        }

        dislikeImg.setOnClickListener {
            handleSwipe(false)
        }

        return view
    }

    private fun setupFlingAdapter() {
        imageAdapter = ImageAdapter(requireContext(), initialData)
        flingAdapterView.adapter = imageAdapter

        flingAdapterView.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
            override fun removeFirstObjectInAdapter() {
                initialData.drop(1)
                imageAdapter.notifyDataSetChanged()
            }

            override fun onLeftCardExit(o: Any) {
                handleSwipeResult("Pass")
            }

            override fun onRightCardExit(o: Any) {
                handleSwipeResult("Admire")
            }

            override fun onAdapterAboutToEmpty(i: Int) {
            }

            override fun onScroll(v: Float) {
            }
        })

        flingAdapterView.setOnItemClickListener(object : SwipeFlingAdapterView.OnItemClickListener {
            override fun onItemClicked(i: Int, o: Any) {
                showToast("data is ${initialData[i]}")
            }
        })
    }

    private fun handleSwipeResult(message: String) {
        showToast(message)
        removeFirstObjectAndNotifyAdapter()
    }

    private fun handleSwipe(isRight: Boolean) {
        canSwipe = false  // Disable swiping until the next image is loaded
        if (isRight) {
            flingAdapterView.topCardListener.selectRight()
        } else {
            flingAdapterView.topCardListener.selectLeft()
        }
        removeFirstObjectAndNotifyAdapter()
    }

    private fun removeFirstObjectAndNotifyAdapter() {
        if (canSwipe && initialData.isNotEmpty()) {
            // Update the current image index
            currentImageIndex++

            // Check if there are more images to display
            if (currentImageIndex < initialData.size) {
                // Create a Transition animation
                val transition = Slide(Gravity.BOTTOM)
                transition.duration = 300 // Adjust the duration as needed
                transition.addTarget(flingAdapterView)

                // Apply the transition to the fragment's container
                TransitionManager.beginDelayedTransition(frameLayout, transition)

                // Update the adapter with the new data
                imageAdapter.setData(listOf(initialData[currentImageIndex]))
                imageAdapter.notifyDataSetChanged()
            } else {
                // Reset the index and reload the data
                currentImageIndex = 0
                initialData.clear()

                // Create a Transition animation
                val transition = Slide(Gravity.BOTTOM)
                transition.duration = 300 // Adjust the duration as needed
                transition.addTarget(flingAdapterView)

                // Apply the transition to the fragment's container
                TransitionManager.beginDelayedTransition(frameLayout, transition)

                // Update the adapter with the new data
                imageAdapter.setData(initialData)
                imageAdapter.notifyDataSetChanged()

                // Handle when there are no more images to display
                showToast("No more images")
            }
        }

        // Reset the flag after each swipe
        canSwipe = true
    }

    private fun showToast(message: String) {
        toastText.text = message
        customToast.view = layout
        customToast.duration = Toast.LENGTH_SHORT
        customToast.show()
    }
}