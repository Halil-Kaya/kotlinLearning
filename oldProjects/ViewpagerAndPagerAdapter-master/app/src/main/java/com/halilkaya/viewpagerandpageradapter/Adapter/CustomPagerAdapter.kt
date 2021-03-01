package com.halilkaya.viewpagerandpageradapter.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.halilkaya.viewpagerandpageradapter.Model.DataModel
import com.halilkaya.viewpagerandpageradapter.R

class CustomPagerAdapter(var context: Context, var itemList: List<DataModel>) : PagerAdapter() {

    var inflater:LayoutInflater = LayoutInflater.from(context)


    override fun getCount(): Int {
        return itemList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view:View
        if(position == 0) {
            view = inflater.inflate(R.layout.test, container, false)
        }else {
            view = inflater.inflate(R.layout.tek_ekran, container, false)

            var img = view.findViewById<ImageView>(R.id.img)
            var title = view.findViewById<TextView>(R.id.baslik)

            img.setImageResource(itemList.get(position).resim)
            title.setText(itemList.get(position).baslik)
        }


        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        if(position == 0){
            container.removeView(`object` as ConstraintLayout)
        }else{

            container.removeView(`object` as FrameLayout)

        }


    }


}