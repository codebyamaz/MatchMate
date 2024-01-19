package com.example.matchmate.fragment;

import com.example.matchmate.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.matchmate.adapter.LikesAdapter
import com.example.matchmate.model.LikesModel

class Likes : Fragment() {

    private lateinit var filter: ImageView
    private lateinit var gridView: GridView
    private var dataModels: ArrayList<LikesModel>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_likes, container, false)
        filter = view.findViewById(R.id.filter)
        gridView = view.findViewById<GridView>(R.id.gridView)

        dataModels = ArrayList()
        val likes1 = LikesModel(R.drawable.girl19, "Leilani, 19", R.drawable.crossvec, R.drawable.likevec)
        val likes2 = LikesModel(R.drawable.g25, "Annabelle, 20", R.drawable.crossvec, R.drawable.likevec)
        val likes3 = LikesModel(R.drawable.girl7, "Emily, 25", R.drawable.crossvec, R.drawable.likevec)
        val likes5 = LikesModel(R.drawable.g24, "Sophia, 20", R.drawable.crossvec, R.drawable.likevec)
        val likes4 = LikesModel(R.drawable.g26, "Olivia, 24", R.drawable.crossvec, R.drawable.likevec)
        val likes6 = LikesModel(R.drawable.girl20, "Lucy, 19", R.drawable.crossvec, R.drawable.likevec)
        val likes7 = LikesModel(R.drawable.g13, "Emma, 29", R.drawable.crossvec, R.drawable.likevec)
        val likes8 = LikesModel(R.drawable.g36, "Laura, 21", R.drawable.crossvec, R.drawable.likevec)
        val likes9 = LikesModel(R.drawable.girl16, "Scarlett, 18", R.drawable.crossvec, R.drawable.likevec)
        val likes10 = LikesModel(R.drawable.g32, "Zoe, 23", R.drawable.crossvec, R.drawable.likevec)
        val likes11 = LikesModel(R.drawable.g20, "Bella, 27", R.drawable.crossvec, R.drawable.likevec)
        val likes12 = LikesModel(R.drawable.g21, "Layla, 21", R.drawable.crossvec, R.drawable.likevec)


        dataModels!!.add(likes1)
        dataModels!!.add(likes2)
        dataModels!!.add(likes3)
        dataModels!!.add(likes4)
        dataModels!!.add(likes5)
        dataModels!!.add(likes6)
        dataModels!!.add(likes7)
        dataModels!!.add(likes8)
        dataModels!!.add(likes9)
        dataModels!!.add(likes10)
        dataModels!!.add(likes11)
        dataModels!!.add(likes12)

        val adapter = LikesAdapter(requireContext(), dataModels!!)
        gridView.numColumns = 2
        gridView.adapter = adapter

        return view
    }
}
