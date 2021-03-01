package com.halilkaya.recyclerviewadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.satir.view.*

class GorevAdapter(var contex:Context,var etGorev:EditText,var radioGroup: RadioGroup):RecyclerView.Adapter<GorevAdapter.GorevViewHolder>() {


    var gorevler:ArrayList<Gorev>

    init {
        gorevler = ArrayList()
    }


    fun gorevEkle(gorev:Gorev){
        gorevler.add(gorev)
        notifyItemInserted(gorevler.size)
        notifyItemRangeChanged(gorevler.size,gorevler.size)
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GorevViewHolder {

        var inflater = LayoutInflater.from(parent.context)

        var tek_satir_View = inflater.inflate(R.layout.satir,parent,false)

        return GorevViewHolder(tek_satir_View)
    }

    override fun getItemCount(): Int {
        return gorevler.size
    }

    override fun onBindViewHolder(holder: GorevViewHolder, position: Int) {

        holder.resim.setImageResource(gorevler.get(position).resim)
        holder.yazi.setText(gorevler.get(position).baslik)

        holder.btnSil.setOnClickListener {
            gorevler.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,gorevler.size)

        }

        holder.btnDuzenle.setOnClickListener {

            if(etGorev.text.isNullOrEmpty()){
                Toast.makeText(contex,"Data gir",Toast.LENGTH_LONG).show()
            }else{

                if (radioGroup.checkedRadioButtonId == R.id.rbIlk){
                    gorevler.get(position).baslik = etGorev.text.toString()
                    gorevler.get(position).resim = R.drawable.birinci
                }else if(radioGroup.checkedRadioButtonId == R.id.rbOrta){
                    gorevler.get(position).baslik = etGorev.text.toString()
                    gorevler.get(position).resim = R.drawable.ikinci
                }else if(radioGroup.checkedRadioButtonId == R.id.rbSon){
                    gorevler.get(position).baslik = etGorev.text.toString()
                    gorevler.get(position).resim = R.drawable.birinci
                }
            }
            notifyDataSetChanged()
        }


        holder.btnKopyala.setOnClickListener {

            gorevler.add(position,gorevler.get(position))
            notifyItemInserted(position)
            notifyItemRangeChanged(position,gorevler.size)
        }

    }



    inner class GorevViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var tekSatir = itemView as CardView

        var yazi = tekSatir.tvYazi
        var resim = tekSatir.imgResim

        var btnSil = tekSatir.btnSil
        var btnDuzenle = tekSatir.btnDuzenle
        var btnKopyala = tekSatir.btnKopyala









    }


}