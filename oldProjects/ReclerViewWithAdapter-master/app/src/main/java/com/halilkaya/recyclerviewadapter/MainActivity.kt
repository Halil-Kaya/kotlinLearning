package com.halilkaya.recyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var myAdapter = GorevAdapter(this,etGorev,radioGroup)

        rootReclerView.adapter = myAdapter

        rootReclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)




        btnEkle.setOnClickListener {

            if(etGorev.text.isNullOrEmpty()){
                Toast.makeText(this,"Gorev Gir",Toast.LENGTH_LONG).show()
            }else{

                if(radioGroup.checkedRadioButtonId == -1){
                    Toast.makeText(this,"Bir resim Sec",Toast.LENGTH_LONG).show()
                }else{


                    if (radioGroup.checkedRadioButtonId == rbIlk.id){
                        myAdapter.gorevEkle(Gorev(etGorev.text.toString(),R.drawable.birinci))
                    }else if(radioGroup.checkedRadioButtonId == rbOrta.id){
                        myAdapter.gorevEkle(Gorev(etGorev.text.toString(),R.drawable.ikinci))
                    }else if(radioGroup.checkedRadioButtonId == rbSon.id){
                        myAdapter.gorevEkle(Gorev(etGorev.text.toString(),R.drawable.ikinci))
                    }



                }





            }




        }












    }
}
