package com.halilkaya.listeviewwithadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.satir.view.*

class GorevBaseAdapter(var contex:Context,var etGorev:EditText,var radioGroup:RadioGroup):BaseAdapter() {

    var gorevler:ArrayList<Gorev>
    init {
        gorevler = ArrayList<Gorev>()
        println("size: "+gorevler.size)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var tek_satir_view = convertView
        var viewHolder:ViewHolder

        if(tek_satir_view == null){
            var inflater = LayoutInflater.from(contex)
            tek_satir_view = inflater.inflate(R.layout.satir,parent,false)

            viewHolder = ViewHolder(tek_satir_view)
            tek_satir_view.tag = viewHolder
        }else{

            viewHolder = tek_satir_view.getTag() as ViewHolder

        }


        viewHolder.gorevText.setText(gorevler.get(position).gorevTxt.toString())
        viewHolder.gorevResim.setImageResource(gorevler.get(position).imgResim)

        tek_satir_view?.btnSil?.setOnClickListener {
            gorevler.removeAt(position)
            notifyDataSetChanged()
        }

        tek_satir_view?.btnDuzenle?.setOnClickListener {

            if(etGorev.text.isNullOrEmpty()){
                Toast.makeText(contex,"Gorev gir",Toast.LENGTH_LONG).show()
            }else{

                if(radioGroup.checkedRadioButtonId == R.id.rbIlk){
                    gorevler.set(position,Gorev(etGorev.text.toString(),R.drawable.birinci))
                }else if(radioGroup.checkedRadioButtonId == R.id.rbOrta){
                    gorevler.set(position,Gorev(etGorev.text.toString(),R.drawable.ikinci))
                }else if(radioGroup.checkedRadioButtonId == R.id.rbSon){
                    gorevler.set(position,Gorev(etGorev.text.toString(),R.drawable.ucuncu))
                }

                notifyDataSetChanged()

            }

        }






        return tek_satir_view

    }



    fun addItem(newGorev:Gorev){
        gorevler.add(newGorev)
        notifyDataSetChanged()
    }



    override fun getItem(position: Int): Any {
        return gorevler.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return gorevler.size
    }

}


class ViewHolder(tek_satir_view:View){

    var gorevResim:ImageView
    var gorevText:TextView

    init {
        gorevResim = tek_satir_view.imgResim
        gorevText = tek_satir_view.txView
    }

}
