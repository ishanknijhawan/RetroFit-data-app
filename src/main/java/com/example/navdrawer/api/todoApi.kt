package com.example.navdrawer.api

import com.example.navdrawer.modal.todoText
import retrofit2.Response
import retrofit2.http.GET

interface todoApi {
    @GET("/todos")
    suspend fun gettodos(): Response<List<todoText>>
}