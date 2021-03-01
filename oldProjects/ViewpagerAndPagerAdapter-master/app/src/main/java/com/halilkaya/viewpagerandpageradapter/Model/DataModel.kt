package com.halilkaya.viewpagerandpageradapter.Model

import com.halilkaya.viewpagerandpageradapter.R

class DataModel(bslk:String,rsm:Int) {

    var baslik:String = bslk
    var resim:Int = rsm

    companion object{


    fun getDataList():List<DataModel>{

        var itemList = ArrayList<DataModel>()

        var resimler = arrayOf(R.drawable.img1
            ,R.drawable.img2
            ,R.drawable.img3
            ,R.drawable.img4
            ,R.drawable.img5
            ,R.drawable.img6)

        var basliklar = arrayOf("resim 1"
            ,"resim 2"
            ,"resim 3"
            ,"resim 4"
            ,"resim 5"
            ,"resim 6")

        for(i in 0..resimler.size-1){

            itemList.add(DataModel(basliklar.get(i),resimler.get(i)))

        }



        return itemList
    }



    }


}