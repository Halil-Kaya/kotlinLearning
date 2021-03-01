package com.halilkaya.tablayout.Tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.halilkaya.tablayout.Fragments.*
import com.halilkaya.tablayout.R
import com.halilkaya.tablayout.adapters.TextTapWithScrollFlagsAdapter
import kotlinx.android.synthetic.main.activity_text_tab_with_scrool_flags.*
import kotlinx.android.synthetic.main.activity_text_tab_with_scrool_flags.myToolbar

class TextTabWithScroolFlags : AppCompatActivity() {

    var fragmentListesi = ArrayList<Fragment>()
    var tabBaslikListesi = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_tab_with_scrool_flags)

        myToolbar.setTitle("Text Tab With Scroll Flags")
        myToolbar.setTitleTextColor(resources.getColor(R.color.colorAccent))

        setData(FragmentOne(),"Tab 1")
        setData(FragmentTwo(),"Tab 2")
        setData(FragmentThree(),"Tab 3")
        setData(FragmentFour(),"Tab 4")
        setData(FragmentFive(),"Tab 5")
        setData(FragmentSix(),"Tab 6")


        var adapter = TextTapWithScrollFlagsAdapter(supportFragmentManager,fragmentListesi,tabBaslikListesi)

        myViewPager.adapter = adapter
        myTabLayout.setTabTextColors(resources.getColor(android.R.color.white),resources.getColor(R.color.colorPrimaryDark))
        myTabLayout.setupWithViewPager(myViewPager)



    }

    fun setData(fragment:Fragment,baslik:String){
        fragmentListesi.add(fragment)
        tabBaslikListesi.add(baslik)
    }




}
