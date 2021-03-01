package com.halilkaya.todoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.halilkaya.todoapp.R
import com.halilkaya.todoapp.model.Todo
import kotlinx.android.synthetic.main.fragment_add_todo.view.*
import kotlinx.android.synthetic.main.tek_satir.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.MyViewHolder>(){

    var myDataList = ArrayList<Todo>()


    fun addTodo(newTodo:Todo){
        myDataList.add(newTodo)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.tek_satir,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myDataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvBaslik.setText(myDataList.get(position).baslik)
        holder.tvNot.setText(myDataList.get(position).not)
        holder.tvTime.setText(myDataList.get(position).time)

        holder.btnSil.setOnClickListener {

            myDataList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,myDataList.size)

        }

    }




    inner class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        var tek_satir = itemView as CardView

        var tvBaslik = tek_satir.tvBaslik
        var tvNot = tek_satir.tvNot
        var tvTime = tek_satir.tvTime
        var btnSil = tek_satir.btnSil



    }

}