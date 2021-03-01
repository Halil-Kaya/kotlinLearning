package com.halilkaya.searchview

import android.widget.Filter

class FilterHelper(var tumDostlar:ArrayList<Dost>,var myAdapter: DostlarReclerViewAdapter) : Filter() {



    override fun performFiltering(constraint: CharSequence?): FilterResults {

        var sonuc = FilterResults()

        if(constraint!=null && constraint.length>0){

            var arananAd = constraint.toString().toLowerCase()

            var eslesenler = ArrayList<Dost>()

            for (dost in tumDostlar){

                if(dost.isim.toLowerCase().contains(arananAd)){
                    eslesenler.add(dost)
                }
            }


            sonuc.values = eslesenler
            sonuc.count = eslesenler.size
        }else{

            sonuc.values = tumDostlar
            sonuc.count = tumDostlar.size

        }

        return sonuc
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

        myAdapter.setFilter(results?.values as ArrayList<Dost>)
        myAdapter.notifyDataSetChanged()

    }
}