package com.halilkaya.jsonwithretrofit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.halilkaya.jsonwithretrofit.FilterHelper
import com.halilkaya.jsonwithretrofit.Model.Kart
import com.halilkaya.jsonwithretrofit.R
import kotlinx.android.synthetic.main.tek_satir.view.*
import java.util.logging.Filter

class WeatherAdapter():RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    var kartlar:ArrayList<Kart> = ArrayList()
    var myFilter:FilterHelper = FilterHelper(kartlar,this)


    fun addItem(newKart:Kart){
        kartlar.add(newKart)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return kartlar.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {


        var inflater = LayoutInflater.from(parent.context)
        var tek_satir = inflater.inflate(R.layout.tek_satir,parent,false)


        return WeatherViewHolder(tek_satir)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {


        holder.tvIl.setText(kartlar.get(position).sehir)
        holder.imgHavaDurum.setImageResource(kartlar.get(position).resim)
        holder.tvSicaklik.setText(kartlar.get(position).sicaklik)

        holder.btnSil.setOnClickListener {
            kartlar.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,kartlar.size)
        }


    }


    fun setFilter(array:ArrayList<Kart>){
        kartlar = array
    }


    inner class WeatherViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var tek_kart = itemView as CardView

        var tvIl = tek_kart.tvIl
        var imgHavaDurum = tek_kart.imgHavaDurum
        var tvSicaklik = tek_kart.tvSicaklik
        var btnSil = tek_kart.btnSil

    }





}