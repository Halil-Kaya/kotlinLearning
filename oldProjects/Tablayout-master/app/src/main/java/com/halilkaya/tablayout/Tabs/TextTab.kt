package com.halilkaya.tablayout.Tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.halilkaya.tablayout.Fragments.*
import com.halilkaya.tablayout.R
import com.halilkaya.tablayout.adapters.TextTapAdapter
import kotlinx.android.synthetic.main.activity_text_tab.*

class TextTab : AppCompatActivity() {

    var fragmentListesi = ArrayList<Fragment>()
    var tabBaslikListesi = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_tab)

        myToolbar.setTitle("Text Tab Ornek")

        setData(FragmentOne(),"Tab 1")
        setData(FragmentTwo(),"Tab 2")
        setData(FragmentThree(),"Tab 3")
        setData(FragmentFour(),"Tab 4")
        setData(FragmentFive(),"Tab 5")
        setData(FragmentSix(),"Tab 6")


        var adapter = TextTapAdapter(supportFragmentManager,fragmentListesi,tabBaslikListesi)

        viewPager.adapter = adapter
        myTabs.setupWithViewPager(viewPager)


    }

    fun setData(fragment:Fragment,baslik:String){
        fragmentListesi.add(fragment)
        tabBaslikListesi.add(baslik)
    }


}
