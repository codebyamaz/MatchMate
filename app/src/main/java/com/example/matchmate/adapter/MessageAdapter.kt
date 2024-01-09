package com.example.matchmate.adapter;

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.matchmate.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.matchmate.activity.ChatActivity
import com.example.matchmate.click.MessageClickListener
import com.example.matchmate.model.MessagesModel

class MessageAdapter(private val dataModel: ArrayList<MessagesModel>) :
    RecyclerView.Adapter<MessageAdapter.viewHolder?>() {
    private var clickListener: MessageClickListener? = null
    fun setClickListener(clickListener: MessageClickListener?) {
        this.clickListener = clickListener
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val personImage: ImageView
        val personName: TextView
        val personMessage: TextView
        val personTime: TextView

        init {
            personImage = itemView.findViewById<ImageView>(R.id.image)
            personName = itemView.findViewById<TextView>(R.id.name)
            personMessage = itemView.findViewById(R.id.message)
            personTime = itemView.findViewById<TextView>(R.id.time)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            clickListener?.onClick(view, adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val listItems: View =
            LayoutInflater.from(parent.context).inflate(R.layout.messages_layout, parent, false)
        return viewHolder(listItems)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val messagesModel = dataModel[position]
        holder.personImage.setImageResource(messagesModel.personImage)
        holder.personName.text = messagesModel.personName
        holder.personMessage.text = messagesModel.personMessage
        holder.personTime.text = messagesModel.personTime

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val name = dataModel[position].personName
            val image = dataModel[position].personImage

            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra("NAME_KEY", name)
            intent.putExtra("IMAGE_KEY", image)

            // Ensure that the context is an activity before starting the activity
            if (context is Activity) {
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "Unable to start activity", Toast.LENGTH_SHORT).show()
            }
        }

}

    override fun getItemCount(): Int {
        return dataModel.size
    }
}