package com.halilkaya.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class DialogFragmenti: DialogFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.diaolg_tasarim,container)

        var listener:MyListener = activity as MyListener

        isCancelable = false


        var btnEvet = view.findViewById<Button>(R.id.btnEvet)
        btnEvet.setOnClickListener {

            listener.dialogVerisiniGonder("Evete Tiklandi")
            dismiss()
        }

        var btnHayir = view.findViewById<Button>(R.id.btnHayir)
        btnHayir.setOnClickListener {

            listener.dialogVerisiniGonder("Hayira Tiklandi")
            dismiss()
        }



        return view
    }

}