package com.example.matchmate.adapter;

import com.example.matchmate.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.example.matchmate.model.LikesModel

class LikesAdapter(
    private val context: Context,
    private val matchesArrayList: ArrayList<LikesModel>
) :
    ArrayAdapter<LikesModel>(context, R.layout.item_layout, matchesArrayList) {
    private class MyViewHolder {
        var relativeLayout: RelativeLayout? = null
        var matchesImg: ImageView? = null
        var matchNameAge: TextView? = null
        var textView: TextView? = null
        var crossImage: ImageView? = null
        var likeImage: ImageView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val dataModel = matchesArrayList[position]
        val myViewHolder: MyViewHolder
        val result: View
        if (convertView == null) {
            myViewHolder = MyViewHolder()
            val inflater = LayoutInflater.from(getContext())
            convertView = inflater.inflate(R.layout.item_layout, parent, false)
            myViewHolder.matchesImg = convertView!!.findViewById<ImageView>(R.id.imageView)
            myViewHolder.matchNameAge = convertView.findViewById<TextView>(R.id.matchNameAge)
            myViewHolder.crossImage = convertView.findViewById<ImageView>(R.id.crossImage)
            myViewHolder.likeImage = convertView.findViewById<ImageView>(R.id.likeImage)
            myViewHolder.relativeLayout = convertView.findViewById<RelativeLayout>(R.id.relativeLayout)
            convertView.setTag(myViewHolder)
            result = convertView
        } else {
            myViewHolder = convertView.tag as MyViewHolder
            result = convertView
        }
        myViewHolder.matchesImg!!.setImageResource(dataModel.matchImage)
        myViewHolder.matchNameAge!!.text = dataModel.matchNameAge
        myViewHolder.crossImage!!.setImageResource(dataModel.crossImage)
        myViewHolder.likeImage!!.setImageResource(dataModel.likeImage)
        myViewHolder.likeImage!!.setOnClickListener { v: View? ->
            val items = getItem(position)
            if (position == 0) {
                val firstItem = getItem(0)
                if (firstItem != null && firstItem.likeImage == R.drawable.likevec) {
                    Toast.makeText(context, "Liked " + firstItem.matchNameAge, Toast.LENGTH_SHORT)
                        .show()

                    // Check if textView is not null before accessing it
                    if (myViewHolder.textView != null) {
                        myViewHolder.textView!!.visibility = View.INVISIBLE
                    }
                }
            } else if (items != null && items.likeImage == R.drawable.likevec) {
                Toast.makeText(context, "Liked " + items.matchNameAge, Toast.LENGTH_SHORT).show()
            }
        }
        return result
    }


    override fun getItem(position: Int): LikesModel {
        return matchesArrayList[position]
    }
}