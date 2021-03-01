package com.halilkaya.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.halilkaya.todoapp.adapters.TextTabAdapter
import com.halilkaya.todoapp.fragments.FragmentAddTodo
import com.halilkaya.todoapp.fragments.FragmentShowTodos
import com.halilkaya.todoapp.model.BaslikVeNot
import com.halilkaya.todoapp.model.Todo
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var fragmentListesi = ArrayList<Fragment>()
    var tabBaslikListesi = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragmentAndTitleData()

        myToolbar.setTitle("Todo App")
        myToolbar.setTitleTextColor(resources.getColor(android.R.color.white))


        var myAdapter = TextTabAdapter(supportFragmentManager,fragmentListesi,tabBaslikListesi)
        myViewPager.adapter = myAdapter
        myTabLayout.setupWithViewPager(myViewPager)


    }


    @Subscribe
    fun datayiAl(baslikVeNot:BaslikVeNot){

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        var todo = Todo(baslikVeNot.baslik,baslikVeNot.not,currentDate)
        EventBus.getDefault().post(todo)
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }



    fun setFragmentAndTitleData(){

        fragmentListesi.add(FragmentAddTodo())
        tabBaslikListesi.add("Ekle")

        fragmentListesi.add(FragmentShowTodos())
        tabBaslikListesi.add("Notlarım")

    }


}
