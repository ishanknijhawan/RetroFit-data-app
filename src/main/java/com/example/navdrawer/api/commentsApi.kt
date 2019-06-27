package com.example.navdrawer.api

import com.example.navdrawer.modal.commentsText
import retrofit2.Response
import retrofit2.http.GET

interface commentsApi {

    @GET("/comments")
    suspend fun getComments() : Response<List<commentsText>>

}