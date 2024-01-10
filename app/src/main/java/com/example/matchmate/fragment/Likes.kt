package com.example.matchmate.fragment;

import com.example.matchmate.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.matchmate.adapter.LikesAdapter
import com.example.matchmate.model.LikesModel

class Likes : Fragment() {
    private var dataModels: ArrayList<LikesModel>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_likes, container, false)
        val gridView = view.findViewById<GridView>(R.id.gridView)
        dataModels = ArrayList()
        val likes1 =
            LikesModel(R.drawable.girl3, "Leilani, 19", R.drawable.crossvec, R.drawable.likevec)
        val likes2 =
            LikesModel(R.drawable.girl9, "Annabelle, 20", R.drawable.crossvec, R.drawable.likevec)
        val likes3 =
            LikesModel(R.drawable.girl7, "Reagon, 25", R.drawable.crossvec, R.drawable.likevec)
        val likes4 =
            LikesModel(R.drawable.girl10, "Hadley, 24", R.drawable.crossvec, R.drawable.likevec)
        dataModels!!.add(likes1)
        dataModels!!.add(likes2)
        dataModels!!.add(likes3)
        dataModels!!.add(likes4)
        val adapter = LikesAdapter(requireContext(), dataModels!!)
        gridView.numColumns = 2
        gridView.adapter = adapter

        return view
    }
}