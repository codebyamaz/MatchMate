package com.example.matchmate.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.matchmate.R
import com.example.matchmate.activity.MatchActivity
import com.example.matchmate.adapter.ImageAdapter
import com.lorentzos.flingswipe.SwipeFlingAdapterView

class Home : Fragment() {
    private var backImg: ImageView? = null
    private var filterImg: ImageView? = null
    private lateinit var dislikeImg: ImageView
    private lateinit var likeImg: ImageView
    private lateinit var starImg: ImageView
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var data: MutableList<Int>
    private lateinit var flingAdapterView: SwipeFlingAdapterView

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

        // Load image resources from the drawable folder
        data = mutableListOf(
            R.drawable.girl1,
            R.drawable.girl2,
            R.drawable.girl4,
            R.drawable.girl10,
            R.drawable.girl9,
            R.drawable.girl8,
            R.drawable.girl7,
            R.drawable.girl6,
            R.drawable.girl3,
            R.drawable.girl5,
            R.drawable.girl1,
            R.drawable.girl2,
            R.drawable.girl4,
            R.drawable.girl10,
            R.drawable.girl9,
            R.drawable.girl8,
            R.drawable.girl7,
            R.drawable.girl6,
            R.drawable.girl3,
            R.drawable.girl5
        )

        imageAdapter = ImageAdapter(requireContext(), data)
        flingAdapterView.adapter = imageAdapter

        flingAdapterView.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
            override fun removeFirstObjectInAdapter() {
                data.removeAt(0)
                imageAdapter.notifyDataSetChanged()
            }

            override fun onLeftCardExit(o: Any) {
                Toast.makeText(requireContext(), "dislike", Toast.LENGTH_SHORT).show()
            }

            override fun onRightCardExit(o: Any) {
                Toast.makeText(requireContext(), "like", Toast.LENGTH_SHORT).show()
            }

            override fun onAdapterAboutToEmpty(i: Int) {}
            override fun onScroll(v: Float) {}
        })

        flingAdapterView.setOnItemClickListener(object :
            SwipeFlingAdapterView.OnItemClickListener {
            override fun onItemClicked(i: Int, o: Any) {
                Toast.makeText(requireContext(), "data is " + data[i], Toast.LENGTH_SHORT)
                    .show()
            }
        })

        starImg.setOnClickListener { flingAdapterView.topCardListener.selectRight() }

        dislikeImg.setOnClickListener { flingAdapterView.topCardListener.selectLeft() }

        likeImg.setOnClickListener {
                val intent = Intent(context, MatchActivity::class.java)
                startActivity(intent)
        }
       /* likeImg.setOnClickListener {
            val currentPosition = flingAdapterView.selectedItemPosition
            if (currentPosition != -1 && currentPosition < data.size) {
                val imageResourceId: Int = data[currentPosition]
                val intent = Intent(context, MatchActivity::class.java)
                intent.putExtra("imageResourceId", imageResourceId)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "No item selected", Toast.LENGTH_SHORT).show()
            }
        }*/





        return view
    }
}
