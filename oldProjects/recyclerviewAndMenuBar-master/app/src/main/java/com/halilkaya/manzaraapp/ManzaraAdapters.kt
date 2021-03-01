package com.halilkaya.manzaraapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_satir.view.*

class ManzaraAdapters(tumManzaralar:ArrayList<Manzara>) : RecyclerView.Adapter<ManzaraAdapters.ManzaraViewHolder>() {


    var manzaralar = tumManzaralar

    override fun getItemCount(): Int {

        return manzaralar.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManzaraViewHolder {

        var inflater = LayoutInflater.from(parent.context)

        var tek_satir_View = inflater.inflate(R.layout.tek_satir,parent,false)

        return ManzaraViewHolder(tek_satir_View)

    }



    override fun onBindViewHolder(holder: ManzaraViewHolder, position: Int) {

        holder.setData(manzaralar.get(position),position)


    }



   inner class ManzaraViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        var tekSatirManzara = itemView as CardView

        var manzaraBaslik = tekSatirManzara.manzaraBaslik
        var manzaraAciklama = tekSatirManzara.manzaraAciklama
        var manzaraResim = tekSatirManzara.imgManzara
        var btnKopyala = tekSatirManzara.imgKopyala
        var btnSil = tekSatirManzara.imgSil

        init{

        }

        fun setData(oAnkiManzara:Manzara,position: Int){

            manzaraBaslik.text = oAnkiManzara.isim
            manzaraAciklama.text = oAnkiManzara.aciklama
            manzaraResim.setImageResource(oAnkiManzara.resim)


            btnKopyala.setOnClickListener {

                manzaralar.add(position,manzaralar.get(position))
                notifyItemInserted(position)
                notifyItemRangeChanged(position,manzaralar.size)

            }

            btnSil.setOnClickListener {

                manzaralar.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,manzaralar.size)

            }


        }


    }





}