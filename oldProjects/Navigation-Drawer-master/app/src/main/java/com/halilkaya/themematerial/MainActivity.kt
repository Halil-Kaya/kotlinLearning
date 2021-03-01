package com.halilkaya.themematerial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar  = myToolbar as androidx.appcompat.widget.Toolbar
        toolbar.setTitle("Helllo")
        toolbar.setSubtitle("whtsp")
        setUpDrawer()
    }

    fun setUpDrawer(){

        var navigationDrawerFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavigationDrawerFragment


        navigationDrawerFragment.setUpNavigationDrawer(draweLayout,toolbar)

    }

}
