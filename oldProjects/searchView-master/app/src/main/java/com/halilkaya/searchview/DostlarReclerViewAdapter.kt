package com.halilkaya.searchview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_uye.view.*

class DostlarReclerViewAdapter(tumDostlar:ArrayList<Dost>) : RecyclerView.Adapter<DostlarReclerViewAdapter.MyViewHolder>(),Filterable {

    var dostlar = tumDostlar
    var myFilter:FilterHelper = FilterHelper(tumDostlar,this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var inflater = LayoutInflater.from(parent.context)

        var tek_uye = inflater.inflate(R.layout.tek_uye,parent,false)


        return MyViewHolder(tek_uye)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.setData(dostlar.get(position),position)

    }

    override fun getItemCount(): Int {
        return dostlar.size
    }



    override fun getFilter(): Filter {
        return myFilter
    }

    fun setFilter(array:ArrayList<Dost>){
        dostlar = array
    }

    /*
    fun setFilter(arananlar:ArrayList<Dost>){

        dostlar = ArrayList<Dost>()
        dostlar.addAll(arananlar)
        notifyDataSetChanged()
    }
    */





    inner class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var tek_uye = itemView as CardView
        var isim = tek_uye.tvDostisim
        var resim = tek_uye.imgDost



    fun setData(dost:Dost,position:Int){
        isim.setText(dost.isim.toString())
        resim.setImageResource(dost.resim)


        tek_uye.setOnClickListener {

            Toast.makeText(tek_uye.context,"Ismi: ${isim.text.toString()} position: $position",Toast.LENGTH_SHORT).show()

        }


    }


    }


}