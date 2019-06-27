package com.example.navdrawer.retroFitClients

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientComments{

    val commentsApi = retrofit()
        .create(com.example.navdrawer.api.commentsApi::class.java)

    private fun retrofit() = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}