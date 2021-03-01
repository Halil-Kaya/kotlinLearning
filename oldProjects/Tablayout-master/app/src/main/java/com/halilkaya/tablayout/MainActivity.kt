package com.halilkaya.tablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.halilkaya.tablayout.Tabs.IconTab
import com.halilkaya.tablayout.Tabs.TextTab
import com.halilkaya.tablayout.Tabs.TextTabWithScroolFlags
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTextTab.setOnClickListener(this)
        btnIconTab.setOnClickListener(this)
        btnTextTabWithScrollFlags.setOnClickListener(this)

        myToolbar.setTitle("TabLayout Ornek")
        myToolbar.setTitleTextColor(resources.getColor(R.color.colorAccent))

    }


    override fun onClick(v: View?) {

        when(v?.id){

            R.id.btnTextTab -> {

                var intent = Intent(this,TextTab::class.java)
                startActivity(intent)

            }

            R.id.btnIconTab -> {


                var intent = Intent(this,IconTab::class.java)
                startActivity(intent)


            }


            R.id.btnTextTabWithScrollFlags -> {

                var intent = Intent(this,TextTabWithScroolFlags::class.java)
                startActivity(intent)

            }


        }


    }
}
