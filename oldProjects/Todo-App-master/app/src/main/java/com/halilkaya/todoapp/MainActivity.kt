package com.halilkaya.todoapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.ColorRes
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("working")


        btnEkle.setOnClickListener {

            if(atTodo.text.isNullOrEmpty()){
                FancyToast.makeText(this,"Write an Todo !",FancyToast.LENGTH_LONG,FancyToast.CONFUSING,false).show()
            }else{

                var todo = atTodo.text.toString()

                var inflater = LayoutInflater.from(this)
                var newTodo = inflater.inflate(R.layout.row,null)

                newTodo.metin.setText(todo)
                newTodo.metin.setTextColor(Color.GRAY)


                newTodo.checkbox.setOnClickListener {
                    if(newTodo.checkbox.isChecked){
                        newTodo.metin.setTextColor(Color.parseColor("#32CD32"))
                    }else{
                        newTodo.metin.setTextColor(Color.GRAY)
                    }
                }

                newTodo.btnDuzenle.setOnClickListener {
                    println(newTodo.metin.text.toString())
                }


                newTodo.btnSil.setOnClickListener {
                    rootLayout.removeView(newTodo)
                }



                atTodo.setText("")
                rootLayout.addView(newTodo)

            }


        }
    }




}
