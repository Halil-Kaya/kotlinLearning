package com.halilkaya.fragmentstatepager.Model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.halilkaya.fragmentstatepager.Fragments.*


class CustomAdapter(var fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    val ITEMS = 6

    override fun getItem(position: Int): Fragment {

        when(position){

            0->{
                return FragmentOne()
            }

            1->{
                return FragmentTwo()
            }

            2->{
                return FragmentThree()
            }
            3->{
                return FragmentFour()
            }

            4->{
                return FragmentFive()
            }

            5->{
                return FragmentSix()
            }

            else -> {
                return FragmentOne()
            }


        }



    }

    override fun getCount(): Int {
        return ITEMS
    }
}