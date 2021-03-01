package com.halilkaya.tablayout.Tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.halilkaya.tablayout.Fragments.*
import com.halilkaya.tablayout.R
import com.halilkaya.tablayout.adapters.IconTapAdapter
import com.halilkaya.tablayout.adapters.TextTapAdapter
import kotlinx.android.synthetic.main.activity_text_tab.*

class IconTab : AppCompatActivity() {


    var fragmentListesi = ArrayList<Fragment>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon_tab)



        myToolbar.setTitle("Text Tab Ornek")

        setData(FragmentOne())
        setData(FragmentTwo())
        setData(FragmentThree())
        setData(FragmentFour())
        setData(FragmentFive())
        setData(FragmentSix())


        var adapter = IconTapAdapter(supportFragmentManager,fragmentListesi)

        viewPager.adapter = adapter
        myTabs.setupWithViewPager(viewPager)
        setTabIcon()

    }

    fun setTabIcon(){
        myTabs.getTabAt(0)?.setIcon(R.drawable.addicon)
        myTabs.getTabAt(1)?.setIcon(R.drawable.deleteicon)
        myTabs.getTabAt(2)?.setIcon(R.drawable.editicon)
        myTabs.getTabAt(3)?.setIcon(R.drawable.kopyalama)
        myTabs.getTabAt(4)?.setIcon(R.drawable.trashicon)
        myTabs.getTabAt(5)?.setIcon(R.drawable.user)

    }


    fun setData(fragment:Fragment){
        fragmentListesi.add(fragment)
    }


}
