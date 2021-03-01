package com.halilkaya.themematerial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    lateinit var contex:Context
    lateinit var inflater:LayoutInflater
    lateinit var mDataList:ArrayList<NavigationDrawerItem>

    constructor(context:Context,data:ArrayList<NavigationDrawerItem>){
        this.contex = context
        mDataList = data
        this.inflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = inflater.inflate(R.layout.tek_satir,parent,false)


        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var tiklanilan = mDataList.get(position)
        holder.setData(tiklanilan,position)

    }




    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        var baslik:TextView = itemView.findViewById(R.id.tvTitle)
        var resim:ImageView = itemView.findViewById(R.id.imgIcon)

        fun setData(tiklanilan:NavigationDrawerItem,position:Int){

            baslik.setText(tiklanilan.baslik)
            resim.setImageResource(tiklanilan.resimId)


        }
    }



}