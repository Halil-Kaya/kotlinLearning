package com.halilkaya.todoapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class TextTabAdapter(fm:FragmentManager,var fragmentListesi:ArrayList<Fragment>,var tabBaslikListesi:ArrayList<String>) : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return fragmentListesi.get(position)
    }


    override fun getCount(): Int {
        return fragmentListesi.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabBaslikListesi.get(position)
    }

}