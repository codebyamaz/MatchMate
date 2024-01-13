package com.example.matchmate.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageAdapter(private val context: Context, private var data: List<Int>) : BaseAdapter() {

    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView

        if (convertView == null) {
            // If convertView is null, inflate the layout for each item
            imageView = ImageView(context)
            imageView.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
            imageView.scaleType = ImageView.ScaleType.FIT_XY
        } else {
            // If convertView is not null, reuse it
            imageView = convertView as ImageView
        }

        // Load image into ImageView using Picasso
        Picasso.get().load(data[position]).into(imageView)

        return imageView
    }

    fun setData(newData: List<Int>) {
        data = newData
        notifyDataSetChanged()
    }

    fun updateData(newData: List<Int>) {
        // Clear the existing data
        data = newData

        // Notify the adapter that the data has changed
        notifyDataSetChanged()
    }

}
