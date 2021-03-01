package com.halilkaya.listeviewwithadapter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var myAdapter = GorevBaseAdapter(this,etGorev,radioGroup)
        rootListView.adapter = myAdapter


        btnEkle.setOnClickListener {


            if(etGorev.text.isNullOrEmpty()){
                Toast.makeText(this,"Gorev Gir ",Toast.LENGTH_LONG).show()
            }else{


                if(radioGroup.checkedRadioButtonId == rbIlk.id){
                    myAdapter.addItem(Gorev(etGorev.text.toString(),R.drawable.birinci))
                }else if(radioGroup.checkedRadioButtonId == rbOrta.id){
                    myAdapter.addItem(Gorev(etGorev.text.toString(),R.drawable.ikinci))
                }else if(radioGroup.checkedRadioButtonId == rbSon.id){
                    myAdapter.addItem(Gorev(etGorev.text.toString(),R.drawable.ucuncu))
                }

            }

        }




    }
}
