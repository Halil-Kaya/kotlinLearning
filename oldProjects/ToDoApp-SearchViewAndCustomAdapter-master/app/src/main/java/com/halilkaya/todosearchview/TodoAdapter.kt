package com.halilkaya.todosearchview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_kart.view.*
import java.util.*
import kotlin.collections.ArrayList

class TodoAdapter(var etBaslik: EditText,var etAciklama: EditText) : RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {


    var allTodo = ArrayList<Todo>()
    var myFilter = FilterHelper(allTodo,this)


    fun addTodo(newTodo : Todo){
        allTodo.add(newTodo)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var inflater = LayoutInflater.from(parent.context)

        var tek_kart = inflater.inflate(R.layout.tek_kart,parent,false)

        return MyViewHolder(tek_kart)
    }

    override fun getItemCount(): Int {
        return allTodo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.tvBaslik.setText(allTodo.get(position).baslik)
        holder.tvAciklama.setText(allTodo.get(position).aciklama)


        holder.tvBaslik.setOnClickListener { view ->

            var intent = Intent(view.context,DetayActivity::class.java)
            intent.putExtra("baslik",holder.tvBaslik.text)
            intent.putExtra("aciklama",holder.tvAciklama.text)

            view.context.startActivity(intent)



        }


        holder.btnDuzenle.setOnClickListener {

            if (etAciklama.text.isNullOrEmpty() || etBaslik.text.isNullOrEmpty()){

                Toast.makeText(etAciklama.context,"Yetersiz Bilgi",Toast.LENGTH_LONG).show()

            }else{

                findTodo(allTodo.get(position).id)?.baslik = etBaslik.text.toString()
                findTodo(allTodo.get(position).id)?.aciklama = etAciklama.text.toString()

                notifyDataSetChanged()

            }




        }

        holder.btnSil.setOnClickListener {

            allTodo.remove(findTodo(allTodo.get(position).id))
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,allTodo.size)

        }

        holder.btnKopyala.setOnClickListener {
            allTodo.add(position,allTodo.get(position))
            notifyItemInserted(position)
            notifyItemRangeChanged(position,allTodo.size)
        }

    }


    fun findTodo(id:UUID):Todo?{

        for (todo in allTodo){
            if(todo.id.equals(id)){
                return todo
            }
        }

        return null

    }


    fun setFilter(newTodoList:ArrayList<Todo>){
        allTodo = newTodoList
        notifyDataSetChanged()
    }




    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        private var tek_kart = itemView as CardView

        var tvBaslik = tek_kart.tvBaslikDetay
        var tvAciklama = tek_kart.tvAciklamaDetay

        var btnSil = tek_kart.btnSil
        var btnDuzenle = tek_kart.btnDuzenle
        var btnKopyala = tek_kart.btnKopyala

    }

}