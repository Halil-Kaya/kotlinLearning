package com.halilkaya.tablayout.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class TextTapAdapter(fm:FragmentManager,var fragmantListesi:ArrayList<Fragment>,var tabBaslikListesi:ArrayList<String>) : FragmentStatePagerAdapter(fm) {




    override fun getItem(position: Int): Fragment {
        return fragmantListesi.get(position)
    }

    override fun getCount(): Int {
        return fragmantListesi.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabBaslikListesi.get(position)
    }


}