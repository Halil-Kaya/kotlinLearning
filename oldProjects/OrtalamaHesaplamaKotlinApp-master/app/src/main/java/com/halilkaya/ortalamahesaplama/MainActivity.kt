package com.halilkaya.ortalamahesaplama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.yeni_ders_layout.view.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var DERSLER = arrayListOf<String>("Matematik","Fizik","Edebiyat","Tarih","Kimya","Türkçe")

        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,DERSLER)

        etDersAdi.setAdapter(adapter)


        butonuGosterVeyaSakla()

        btnEkle.setOnClickListener {


            if(!etDersAdi.text.isNullOrEmpty()){


            var dersAdi = etDersAdi.text.toString()
            var dersKredi = spKredi.selectedItemPosition
            var dersHarf = spNotlar.selectedItemPosition

            var inflater = LayoutInflater.from(this)
            var yeniDersView = inflater.inflate(R.layout.yeni_ders_layout,null)

            yeniDersView.etNewDersAdi.setText(dersAdi)
            yeniDersView.spNewKredi.setSelection(dersKredi)
            yeniDersView.spNewNotlar.setSelection(dersHarf)


            yeniDersView.btnSil.setOnClickListener {
                rootLayout.removeView(yeniDersView)
                butonuGosterVeyaSakla()
            }


            rootLayout.addView(yeniDersView)
            butonuGosterVeyaSakla()
            sifirla()

            }else{
                FancyToast.makeText(this,"Ders Adı Gir !",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show()
            }


        }



    }

    fun butonuGosterVeyaSakla(){
        if(rootLayout.childCount==0){
            ortHesapla.visibility = View.INVISIBLE
        }else{
            ortHesapla.visibility = View.VISIBLE
        }
    }

    fun sifirla(){
        etDersAdi.setText("")
        spKredi.setSelection(0)
        spNotlar.setSelection(0)
    }

    fun ortalamaHesapla(view:View){


        val dersler:ArrayList<Ders> = ArrayList()
        var toplamNot:Double = 0.0
        var toplamKredi:Double =0.0

        for(i in 0..rootLayout.childCount-1){
            val tekSatir = rootLayout.getChildAt(i)
            dersler.add(Ders(tekSatir.etNewDersAdi.toString(),
                (tekSatir.spNewKredi.selectedItemPosition+1).toDouble(),
                harfToNot(tekSatir.spNewNotlar.selectedItem.toString()))
            )
        }

        for(ders in dersler){
            toplamNot+= ders.not * ders.kredi
            toplamKredi+= ders.kredi
        }

        val ortalama:Double = toplamNot/toplamKredi

        FancyToast.makeText(this,"Ortalama: $ortalama",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,false).show()
    }



    fun harfToNot(harf:String):Double{

        var not:Double = 0.0

        when(harf){
            "AA" -> not = 4.0
            "BA" -> not = 3.5
            "BB" -> not = 3.0
            "CB" -> not = 2.5
            "CC" -> not = 2.0
            "DC" -> not = 1.5
            "DD" -> not = 1.0
            "FF" -> not = 0.0
        }

        return not

    }


}
