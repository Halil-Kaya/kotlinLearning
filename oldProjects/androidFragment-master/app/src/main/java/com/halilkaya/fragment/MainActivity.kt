package com.halilkaya.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MyListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        showDialog.setOnClickListener {

            var dialogFragmenti = DialogFragmenti()

            var manager = supportFragmentManager
            dialogFragmenti.show(manager,"My dialog")

        }


    }



    override fun dialogVerisiniGonder(mesaj: String) {
        Toast.makeText(this,mesaj,Toast.LENGTH_SHORT).show()
    }


}
