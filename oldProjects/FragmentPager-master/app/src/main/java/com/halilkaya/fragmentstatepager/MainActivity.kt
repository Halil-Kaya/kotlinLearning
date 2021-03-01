package com.halilkaya.fragmentstatepager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.halilkaya.fragmentstatepager.Model.CustomAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myAdapter = CustomAdapter(supportFragmentManager)
        viewPager.adapter = myAdapter


    }
}
