package com.halilkaya.greenroboteventbus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var manager = supportFragmentManager

        var transiction = manager.beginTransaction()
        var fragmentA = FragmentA()
        var fragmentB = FragmentB()

        transiction.add(R.id.frameLayoutA,fragmentA,"frgA")
        transiction.add(R.id.frameLayoutB,fragmentB)

        transiction.commit()


    }

    @Subscribe
    fun datayiAl(sayilar:Global.Sayilar){

        var toplam = sayilar.sayi1 + sayilar.sayi2
        EventBus.getDefault().post(Global.Toplami(toplam))
    }



    override fun onStart() {
        EventBus.getDefault().register(this)
        super.onStart()
    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }



}
