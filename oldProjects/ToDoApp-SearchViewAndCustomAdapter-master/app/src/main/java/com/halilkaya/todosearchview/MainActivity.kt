package com.halilkaya.todosearchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var myAdapter = TodoAdapter(etBaslik,etYazi)
        reclerViewRoot.adapter = myAdapter


        var myLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        reclerViewRoot.layoutManager = myLayoutManager



        btnEkle.setOnClickListener {

            if(etBaslik.text.isNullOrEmpty() || etYazi.text.isNullOrEmpty()){
                Toast.makeText(this,"eksik bilgi",Toast.LENGTH_LONG).show()
            }else{

                if(etBaslik.text.toString().toLowerCase().contains(searchView.query.toString().toLowerCase())){

                    myAdapter.addTodo(Todo(etBaslik.text.toString(),etYazi.text.toString()))
                    myAdapter.notifyDataSetChanged()

                }else{

                    myAdapter.addTodo(Todo(etBaslik.text.toString(),etYazi.text.toString()))

                }

            }


        }



        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                myAdapter.myFilter.filter(newText)
                return false
            }

        })







    }
}
