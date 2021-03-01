package com.halilkaya.jsonwithretrofit.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitConnection {

   val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    var retrofit:Retrofit? = null

    val client:Retrofit?
        get(){
        if(retrofit == null){
            retrofit=Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
            return retrofit
    }




}