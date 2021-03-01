package com.halilkaya.jsonwithretrofit.Service

import com.halilkaya.jsonwithretrofit.Model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
//https://api.openweathermap.org/data/2.5/weather?q=Ankara,tr&appid=5ff5f6121eced2f3ad373070cbbb2040&lang=tr&units=metric


    @GET("weather")
    fun getWeather(@Query("q")weather:String,
                   @Query("appid") appid:String,
                   @Query("lang") lang:String,
                   @Query("units") units:String):Call<Weather>

}