package com.halilkaya.inflateagain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.satir.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnEkle.setOnClickListener {

            if(etGorev.text.isNullOrEmpty()){
                Toast.makeText(this,"Gorev Gir",Toast.LENGTH_LONG).show()
            }else{

                var eklenecekTxt = etGorev.text.toString()

                var inflater = LayoutInflater.from(this)

                var newGorevView = inflater.inflate(R.layout.satir,null)

                newGorevView.yeniGorev.setText(eklenecekTxt)




                newGorevView.btnSil.setOnClickListener {
                    root.removeView(newGorevView)
                }

                root.addView(newGorevView)






            }





        }


    }
}
