package com.example.navdrawer.api

import com.example.navdrawer.modal.PostText
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    suspend fun getPosts(): Response<List<PostText>>
}