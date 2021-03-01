package com.halilkaya.shellwebegana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.CheckBox
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    val KILO_TO_POUND = 2.2045
    val MARS = 0.38
    val POUND_TO_KILO = 0.45359237
    val VENUS = 0.91
    val JUPITER = 2.34

    var sayi:Editable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this).load(R.drawable.resim).into(imageView)

        sayi = txt.text

        sonuc.text = savedInstanceState?.getString("sonuc")

        cbJupiter.setOnClickListener {
            cbMars.isChecked = false
            cbVenus.isChecked = false

            calculate(JUPITER)
        }

        cbMars.setOnClickListener {
            cbJupiter.isChecked = false
            cbVenus.isChecked = false

            calculate(MARS)
        }

        cbVenus.setOnClickListener {
            cbMars.isChecked = false
            cbJupiter.isChecked = false

            calculate(VENUS)

        }



    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if(sonuc.text.isEmpty()){
            outState.putString("sonuc","0")
        }else {
            outState.putString("sonuc", sonuc.text.toString())
        }
    }


    fun calculate(whichEarth:Double){

        var kilo:Double = 0.0
        var pound:Double = 0.0


        if(sayi!!.isEmpty()){
            sonuc.text="Sayi giriniz"
        }else{
            kilo = sayi.toString().toDouble()
            pound = kiloToPound(kilo)
            sonuc.text = poundToKilo(pound * whichEarth).format(2).toString()
        }

    }




    fun kiloToPound(kilo:Double):Double{
        return kilo * KILO_TO_POUND
    }

    fun poundToKilo(pound:Double):Double{
        return pound * POUND_TO_KILO
    }

    fun Double.format(rakamSayisi:Int) = java.lang.String.format("%.${rakamSayisi}f",this)


}



