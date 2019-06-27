package com.example.navdrawer.retroFitClients

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{

    val UserApi = retrofit()
        .create(com.example.navdrawer.api.UserApi::class.java)

    private fun retrofit() = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}