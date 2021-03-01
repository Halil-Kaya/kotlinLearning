package com.halilkaya.todoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.halilkaya.todoapp.R
import com.halilkaya.todoapp.adapters.TodoAdapter
import com.halilkaya.todoapp.model.Todo
import kotlinx.android.synthetic.main.fragment_show_todo.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class FragmentShowTodos: Fragment() {

    var myAdapter = TodoAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_show_todo,container,false)

        var myRyclerView = view.findViewById<RecyclerView>(R.id.myReclerView)
        myRyclerView.adapter = myAdapter



        var myLayoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        myRyclerView.layoutManager = myLayoutManager

        return view
    }

    @Subscribe
    fun datayiAl(todo:Todo){
        myAdapter.addTodo(todo)
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }




}