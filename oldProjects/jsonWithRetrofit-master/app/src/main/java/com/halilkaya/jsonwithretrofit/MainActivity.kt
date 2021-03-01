package com.halilkaya.jsonwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.halilkaya.jsonwithretrofit.Adapter.WeatherAdapter
import com.halilkaya.jsonwithretrofit.Model.Kart
import com.halilkaya.jsonwithretrofit.Model.Weather
import com.halilkaya.jsonwithretrofit.Service.ApiInterface
import com.halilkaya.jsonwithretrofit.Service.RetrofitConnection
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*

class MainActivity : AppCompatActivity() {
    var myAdapter = WeatherAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        reclerViewRoot.adapter = myAdapter
        var myLayoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        reclerViewRoot.layoutManager = myLayoutManager




        btnEkle.setOnClickListener {
            if(!etInput.text.isNullOrEmpty()){

                var sehir = etInput.text.toString()
                sehir = sehir.toLowerCase()
                sehir = sehir.capitalize()
                addCard(sehir)
            }
        }


        searcView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                myAdapter.myFilter.filter(newText)
                return false
            }

        })


    }



    fun addCard(istenilenSehir:String){

        //https://api.openweathermap.org/data/2.5/weather?q=Ankara,tr&appid=5ff5f6121eced2f3ad373070cbbb2040&lang=tr&units=metric
        val APPID = "5ff5f6121eced2f3ad373070cbbb2040"
        val LANG = "tr"
        val UNITS = "metric"
        val PROVINCE = istenilenSehir+",tr"

        var call:Call<Weather>? = RetrofitConnection().client?.create(ApiInterface::class.java)?.getWeather(PROVINCE,APPID,LANG,UNITS)

        call?.enqueue(object : Callback<Weather>{

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {


                var gelenVeriler = response.body()



                //var sehir:String,var resim:Int,var sicaklik:String
                var sehir = gelenVeriler?.name.toString()
                var sicaklik = gelenVeriler?.main?.temp.toString()
                var icon = gelenVeriler?.weather?.get(0)?.icon
                println("gelen sehir: $sehir")
                if (sehir.equals("null")){
                    Toast.makeText(this@MainActivity,"gecersiz sehir",Toast.LENGTH_LONG).show()
                }else {

                    var resimDosyaAdi = resources.getIdentifier(
                        "icon_" + icon.toString(),
                        "drawable",
                        packageName
                    ) //R.drawable.50d

                    var newKart: Kart = Kart(sehir, resimDosyaAdi, sicaklik)

                    myAdapter.addItem(newKart)
                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                println("ERROR: "+t.message)
            }

        })




    }




}
