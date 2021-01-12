package com.example.softuserassignment.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softuserassignment.MainActivity
import com.example.softuserassignment.R
import com.example.softuserassignment.adapter.UserAdapter

class HomeFragment : Fragment() {

    private lateinit var rView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_home, container, false)
        rView = view?.findViewById(R.id.rView) as RecyclerView
        val userAdapter = UserAdapter(MainActivity.UserList, this.activity as Context)
        rView!!.adapter = userAdapter
        rView!!.layoutManager = LinearLayoutManager(this.activity as Context?)
        return view
    }
}