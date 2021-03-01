package com.halilkaya.themematerial

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NavigationDrawerFragment : Fragment() {

    lateinit var mDrawerLayout: DrawerLayout
    lateinit var mDrawerToogle: ActionBarDrawerToggle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_navigation_drawer_layout,container,false)

        setUpRecyclerView(view)

        return view
    }


    fun setUpRecyclerView(v:View){

        var reclerView = v.findViewById<RecyclerView>(R.id.drawrList)

        var myAdapter = MyAdapter(activity as Context,NavigationDrawerItem.getData())

        reclerView.adapter = myAdapter
        reclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)

    }

    fun setUpNavigationDrawer(drawerLayout:DrawerLayout,toolbar:androidx.appcompat.widget.Toolbar){

        mDrawerLayout = drawerLayout
        mDrawerToogle = ActionBarDrawerToggle(activity,mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close)

        mDrawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener{

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                mDrawerToogle.onDrawerSlide(drawerView,slideOffset)
            }

            override fun onDrawerOpened(drawerView: View) {
                Toast.makeText(activity,"acildi",Toast.LENGTH_SHORT).show()
            }

            override fun onDrawerClosed(drawerView: View) {
                Toast.makeText(activity,"kapandi",Toast.LENGTH_SHORT).show()
            }

            override fun onDrawerStateChanged(newState: Int) {

            }

        })

        mDrawerLayout.post(object : Runnable{
            override fun run() {
                mDrawerToogle.syncState()
            }

        })


    }

}