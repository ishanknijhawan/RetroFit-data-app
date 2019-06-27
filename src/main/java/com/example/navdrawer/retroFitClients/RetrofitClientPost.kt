package com.example.navdrawer.retroFitClients

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientPost{

    val PostApi = retrofit()
        .create(com.example.navdrawer.api.PostApi::class.java)

    private fun retrofit() = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}