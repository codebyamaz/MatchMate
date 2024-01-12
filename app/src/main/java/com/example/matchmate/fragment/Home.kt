package com.example.matchmate.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.matchmate.R
import com.example.matchmate.adapter.ImageAdapter
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import kotlin.properties.Delegates

class Home : Fragment() {

    private var currentImageIndex by Delegates.notNull<Int>()
    private var backImg: ImageView? = null
    private var filterImg: ImageView? = null
    private lateinit var dislikeImg: ImageView
    private lateinit var likeImg: ImageView
    private lateinit var starImg: ImageView
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var flingAdapterView: SwipeFlingAdapterView

    private val initialData = listOf(
        R.drawable.girl2,
        R.drawable.girl3,
        R.drawable.girl5,
        R.drawable.girl7,
        R.drawable.girl8,
        R.drawable.girl9,
        R.drawable.g1,
        R.drawable.g2,
        R.drawable.g4,
        R.drawable.g5,
        R.drawable.g7,
        R.drawable.g3,
        )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        backImg = view.findViewById(R.id.backImage)
        filterImg = view.findViewById(R.id.filterImage)
        dislikeImg = view.findViewById(R.id.dislikeImage)
        likeImg = view.findViewById(R.id.likeImage)
        starImg = view.findViewById(R.id.starImage)

        flingAdapterView = view.findViewById(R.id.swipe)

        currentImageIndex = 0
        setupFlingAdapter()

        dislikeImg.setOnClickListener {
            flingAdapterView.topCardListener.selectLeft()
            removeFirstObjectAndNotifyAdapter()
        }

        likeImg.setOnClickListener {
            flingAdapterView.topCardListener.selectRight()
            removeFirstObjectAndNotifyAdapter()
        }

        return view
    }

    private fun setupFlingAdapter() {
        imageAdapter = ImageAdapter(requireContext(), initialData)
        flingAdapterView.adapter = imageAdapter

        flingAdapterView.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
            override fun removeFirstObjectInAdapter() {
                // Create a new list without the first element
                initialData.drop(1)
                imageAdapter.notifyDataSetChanged()
            }

            override fun onLeftCardExit(o: Any) {
                showToast("dislike")
                removeFirstObjectAndNotifyAdapter()
            }

            override fun onRightCardExit(o: Any) {
                showToast("like")
                removeFirstObjectAndNotifyAdapter()
            }

            override fun onAdapterAboutToEmpty(i: Int) {
                // Load more data or reset the adapter if needed
            }

            override fun onScroll(v: Float) {
                // Handle scrolling events if needed
            }
        })

        flingAdapterView.setOnItemClickListener(object : SwipeFlingAdapterView.OnItemClickListener {
            override fun onItemClicked(i: Int, o: Any) {
                showToast("data is ${initialData[i]}")
            }
        })
    }

    private fun removeFirstObjectAndNotifyAdapter() {
        currentImageIndex++
        if (currentImageIndex < initialData.size) {
            imageAdapter = ImageAdapter(requireContext(), listOf(initialData[currentImageIndex]))
            flingAdapterView.adapter = imageAdapter
            imageAdapter.notifyDataSetChanged()
        } else {
            currentImageIndex = 0
            imageAdapter = ImageAdapter(requireContext(), initialData)
            flingAdapterView.adapter = imageAdapter
            imageAdapter.notifyDataSetChanged()
            showToast("No more images")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
