package com.halilkaya.layoutlariogreniyorum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun linearActivity(view: View){
        val intent = Intent(this,LinearLayoutActivity::class.java)
        startActivity(intent)
    }

    fun relativeLayout(view:View){
        val intent = Intent(this,RealitiveActivity::class.java)
        startActivity(intent)
    }



    fun frameLayout(view: View){
        startActivity(Intent(this,FrameLayout::class.java))
    }

    fun tableLayout(view: View){
        startActivity(Intent(this,TableLayout::class.java))
    }


    fun tableLayout2(view: View){
        startActivity(Intent(this,TableLayout2::class.java))
    }

    fun gridLayout(view:View){
        startActivity(Intent(this,gridLayout::class.java))
    }




}
