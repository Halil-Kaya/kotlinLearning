package com.halilkaya.tablayout.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class IconTapAdapter(fm:FragmentManager, var fragmantListesi:ArrayList<Fragment>) : FragmentStatePagerAdapter(fm) {




    override fun getItem(position: Int): Fragment {
        return fragmantListesi.get(position)
    }

    override fun getCount(): Int {
        return fragmantListesi.size
    }



}