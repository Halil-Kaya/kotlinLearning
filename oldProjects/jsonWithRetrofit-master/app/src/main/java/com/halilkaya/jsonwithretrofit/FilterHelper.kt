package com.halilkaya.jsonwithretrofit

import com.halilkaya.jsonwithretrofit.Adapter.WeatherAdapter
import com.halilkaya.jsonwithretrofit.Model.Kart

class FilterHelper(var kartlar:ArrayList<Kart>,var myAdapter: WeatherAdapter) : android.widget.Filter() {
    override fun performFiltering(constraint: CharSequence?): FilterResults {

        var sonuc = FilterResults()

        if(constraint!=null && constraint.length>0){

            var arananAd = constraint.toString().toLowerCase()

            var eslesenler = ArrayList<Kart>()

            for (kart in kartlar){

                if(kart.sehir.toLowerCase().contains(arananAd)){
                    eslesenler.add(kart)
                }
            }


            sonuc.values = eslesenler
            sonuc.count = eslesenler.size
        }else{

            sonuc.values = kartlar
            sonuc.count = kartlar.size

        }
        return sonuc
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        myAdapter.setFilter(results?.values as ArrayList<Kart>)
        myAdapter.notifyDataSetChanged()
    }


}