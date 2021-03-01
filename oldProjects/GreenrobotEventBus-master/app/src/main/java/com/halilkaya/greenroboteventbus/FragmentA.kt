package com.halilkaya.greenroboteventbus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.greenrobot.eventbus.EventBus

class FragmentA: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var v = inflater.inflate(R.layout.fragment_a,container,false)

        var etSayi1 = v.findViewById<EditText>(R.id.etSayi1)
        var etSayi2 = v.findViewById<EditText>(R.id.etSayi2)

        var btnHesapla = v.findViewById<Button>(R.id.btnHesapla)
        btnHesapla.setOnClickListener {

            if(etSayi1.text.isNullOrEmpty() || etSayi2.text.isNullOrEmpty()){

                Toast.makeText(activity,"Sayi giriniz",Toast.LENGTH_SHORT).show()

            }else{

                var sayi1 = Integer.valueOf(etSayi1.text.toString())
                var sayi2 = Integer.valueOf(etSayi2.text.toString())

                Toast.makeText(activity,"calisti",Toast.LENGTH_SHORT).show()
                EventBus.getDefault().post(Global.Sayilar(sayi1,sayi2))

            }


        }


        return v
    }


}