package com.halilkaya.todosearchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.tek_kart.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var gelenIntent = intent

        if(gelenIntent != null){

            var baslik = gelenIntent.getStringExtra("baslik")
            var aciklama = gelenIntent.getStringExtra("aciklama")


            tvBaslikDetay.setText(baslik)
            tvAciklamaDetay.setText(aciklama)

        }

    }
}
