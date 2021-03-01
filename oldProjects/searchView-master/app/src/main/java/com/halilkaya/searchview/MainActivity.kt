package com.halilkaya.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){//,SearchView.OnQueryTextListener {


    var tumDostlar:ArrayList<Dost> = ArrayList()
    lateinit var myAdapter:DostlarReclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        veriKaynaginiDoldur()

        myAdapter = DostlarReclerViewAdapter(tumDostlar)

        reclerViewRoot.adapter = myAdapter

        var myLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        reclerViewRoot.layoutManager = myLayoutManager

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                myAdapter.filter.filter(newText)
                return false
            }

        })


    }




    private fun veriKaynaginiDoldur() {

        var resimler = arrayOf(R.drawable.ani_cat_one,
                R.drawable.ani_cat_two,
                R.drawable.ani_cat_three,
                R.drawable.ani_cat_four,
                R.drawable.ani_cat_five,
                R.drawable.ani_cat_six,
                R.drawable.ani_cat_seven,

                R.drawable.ani_dog_one,
                R.drawable.ani_dog_two,
                R.drawable.ani_dog_four,
                R.drawable.ani_dog_five,

                R.drawable.ani_deer_one,
                R.drawable.ani_deer_two,
                R.drawable.ani_deer_three,
                R.drawable.ani_deer_four,

                R.drawable.bird_parrot_one,
                R.drawable.bird_parrot_four,
                R.drawable.bird_parrot_five,
                R.drawable.bird_parrot_six,
                R.drawable.bird_parrot_eight)

        var isimler = arrayOf("Kedi 1", "Kedi 2", "Kedi 3", "Kedi 4", "Kedi 5", "Kedi 6", "Kedi 7",
                "Köpek 1", "Köpek 2", "Köpek 3", "Köpek 4",
                "Geyik 1", "Geyik 2", "Geyik 3", "Geyik 4",
                " Papagan 1", " Papagan 2", " Papagan 3", " Papagan 4", " Papagan 5")

        for (i in 0..resimler.size - 1) {

            var eklenecekDost = Dost(isimler[i], resimler[i])
            tumDostlar.add(eklenecekDost)

        }


    }








/*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.filter_menu,menu)

        var aramaItem = menu?.findItem(R.id.app_bar_search)

        var searchView = aramaItem?.actionView as SearchView

        searchView.setOnQueryTextListener(this)


        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        var girilenVeri = newText?.toLowerCase()

        var arananlar = ArrayList<Dost>()

        for(dost in tumDostlar){
            if(dost.isim.toLowerCase().contains(girilenVeri.toString())){
                arananlar.add(dost)
            }
        }

        myAdapter.setFilter(arananlar)


        return true
    }
*/

}
