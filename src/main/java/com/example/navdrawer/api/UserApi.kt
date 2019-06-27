package com.example.navdrawer.api

import com.example.navdrawer.modal.User
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {

        @GET("/users")
        suspend fun getUsers(): Response<List<User>>

    }