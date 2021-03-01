package com.halilkaya.viewpagerandpageradapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.halilkaya.viewpagerandpageradapter.Adapter.CustomPagerAdapter
import com.halilkaya.viewpagerandpageradapter.Model.DataModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myAdapter = CustomPagerAdapter(this,DataModel.getDataList())

        viewPager.setAdapter(myAdapter)


    }



}
