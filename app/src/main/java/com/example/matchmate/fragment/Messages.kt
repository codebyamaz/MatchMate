package com.example.dating

import com.example.matchmate.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.matchmate.activity.ChatActivity
import com.example.matchmate.adapter.MessageAdapter
import com.example.matchmate.click.MessageClickListener
import com.example.matchmate.extra.DividerItemDecoration
import com.example.matchmate.fragment.ProfileInfo
import com.example.matchmate.model.MessagesModel

class Messages : Fragment() {

    private lateinit var filter: ImageView
    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private var dataModels: ArrayList<MessagesModel>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_messages, container, false)
        filter = view.findViewById(R.id.filterImg)
        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById<SearchView>(R.id.searchView)

        dataModels = ArrayList()
        dataModels!!.add(MessagesModel(R.drawable.g25, "Olivia", "Typing...", "22 min"))
        dataModels!!.add(MessagesModel(R.drawable.girl19, "Emma", "Hey, How are you?", "17 min"))
        dataModels!!.add(MessagesModel(R.drawable.g20, "Ava", "What's up?", "35 min"))

        dataModels!!.add(
            MessagesModel(
                R.drawable.girl20,
                "Sophia",
                "You: How was your day?",
                "30 min"
            )
        )
        dataModels!!.add(
            MessagesModel(
                R.drawable.g29,
                "Amelia",
                "When are we meeting?",
                "48 min"
            )
        )
        dataModels!!.add(
            MessagesModel(
                R.drawable.g26,
                "Isabella",
                "Let's catch up soon!",
                "20 min"
            )
        )
        dataModels!!.add(MessagesModel(R.drawable.girl7, "Mia", "You: Hey!", "50 min"))
        dataModels!!.add(MessagesModel(R.drawable.g32, "Harper", "Good night!", "10 min"))
        dataModels!!.add(
            MessagesModel(
                R.drawable.girl9,
                "Evelyn",
                "You: LOL, that's hilarious!",
                "5 min"
            )
        )
        dataModels!!.add(
            MessagesModel(
                R.drawable.g19,
                "Abigail",
                "Can you send me the details?",
                "40 min"
            )
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = MessageAdapter(dataModels!!)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(context, R.drawable.divider)
        recyclerView.addItemDecoration(dividerItemDecoration)
        return view
    }

}