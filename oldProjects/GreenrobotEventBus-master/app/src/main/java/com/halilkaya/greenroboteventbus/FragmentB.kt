package com.halilkaya.greenroboteventbus

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class FragmentB: Fragment() {

    lateinit var tvSonuc:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var v = inflater.inflate(R.layout.fragment_b,container,false)

        tvSonuc = v.findViewById(R.id.tvSonuc)


        return v
    }

    @Subscribe
    fun dataGeldi(toplam:Global.Toplami){

        tvSonuc.setText("Sonuc: ${toplam.toplami}")


    }


    override fun onAttach(context: Context) {
        EventBus.getDefault().register(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        EventBus.getDefault().unregister(this)
        super.onDetach()
    }



}