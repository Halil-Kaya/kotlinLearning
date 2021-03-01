package com.halilkaya.manzaraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tumManzaralar = datayiDoldur()

        reclerViewim.adapter = ManzaraAdapters(tumManzaralar)

        var linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        reclerViewim.layoutManager = linearLayoutManager



    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.ana_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var id = item.itemId

        if(id == R.id.menuLinearVertical){


        }else if(id == R.id.menuLinearHorizontal){
            var linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            reclerViewim.layoutManager = linearLayoutManager


        }else if(id == R.id.menuGrid){
            var menuGrid = GridLayoutManager(this,2)
            reclerViewim.layoutManager = menuGrid


        }else if(id == R.id.menuStaggeredVertical){
            var menuStaggeredVertical = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            reclerViewim.layoutManager = menuStaggeredVertical

        }else if(id == R.id.menuStaggeredHorizontal){
            var menuStaggeredHorizontal = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
            reclerViewim.layoutManager = menuStaggeredHorizontal

        }



        return super.onOptionsItemSelected(item)
    }





    fun datayiDoldur():ArrayList<Manzara>{

        var resimler = arrayOf(R.drawable.resim1,R.drawable.resim3,R.drawable.resim3,R.drawable.resim4,R.drawable.resim1,R.drawable.resim1,R.drawable.resim1,R.drawable.resim3,R.drawable.resim3,R.drawable.resim4,R.drawable.resim1,R.drawable.resim1
        ,R.drawable.resim1,R.drawable.resim3,R.drawable.resim3,R.drawable.resim4,R.drawable.resim1,R.drawable.resim1
        ,R.drawable.resim1,R.drawable.resim3,R.drawable.resim3,R.drawable.resim4,R.drawable.resim1,R.drawable.resim1
        ,R.drawable.resim1,R.drawable.resim3,R.drawable.resim3,R.drawable.resim4,R.drawable.resim1,R.drawable.resim1)
        var tumManzaralar = ArrayList<Manzara>()



        for(i in 0..resimler.size-1){
            tumManzaralar.add(Manzara("Manzara $i","Aciklama $i",resimler.get(i)))
        }


        return tumManzaralar
    }




}
