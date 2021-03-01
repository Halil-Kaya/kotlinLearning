package com.halilkaya.jsonwithvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import gr.escsoft.michaelprimez.searchablespinner.interfaces.OnItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*
        val queue = Volley.newRequestQueue(this)
        val url = "http://www.google.com"
        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->

                    Toast.makeText(this,"Response is: ${response.substring(0, 500)}",Toast.LENGTH_LONG).show()

                },
                Response.ErrorListener {

                    Toast.makeText(this,"Olmadi",Toast.LENGTH_LONG).show()

                })

        queue.add(stringRequest)
*/


    /*
        var request = StringRequest(Request.Method.GET,"http://www.google.com", Response.Listener<String>{response ->
                Toast.makeText(this@MainActivity,"cevap: $response",Toast.LENGTH_LONG).show()
        },Response.ErrorListener {
                Toast.makeText(this@MainActivity,"hata",Toast.LENGTH_LONG).show()
        })

        MySingleton.getInstance(this).addToRequestQueue(request)
    */



        var spinnerAdapter = ArrayAdapter.createFromResource(this,R.array.sehirler,android.R.layout.simple_spinner_item)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        SearchableSpinner.setAdapter(spinnerAdapter)
        

        SearchableSpinner.setOnItemSelectedListener(this)

        verileriGetir("Ankara")

    }

    fun verileriGetir(sehir:String){
        val url = "https://api.openweathermap.org/data/2.5/weather?q="+sehir+",tr&appid=5ff5f6121eced2f3ad373070cbbb2040&lang=tr&units=metric\n"

        var request = JsonObjectRequest(Request.Method.GET,url,null,Response.Listener<JSONObject> {response ->

            var main = response.getJSONObject("main")
            var name  = response.get("name")
            var temp = main.getString("temp")

            tvSehir.setText(name.toString())
            tvSicaklik.setText(temp.toString())




        },Response.ErrorListener {

            Toast.makeText(this@MainActivity,"hata",Toast.LENGTH_LONG).show()

        })
        MySingleton.getInstance(this).addToRequestQueue(request)

    }




    override fun onNothingSelected() {
    }

    override fun onItemSelected(view: View?, position: Int, id: Long) {
        var secilenSehir =resources.getStringArray(R.array.sehirler)
        println(secilenSehir[position])
        verileriGetir(secilenSehir[position])
    }


}
