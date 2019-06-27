package com.example.navdrawer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navdrawer.R
import com.example.navdrawer.modal.User
import com.example.navdrawer.adapters.UserAdapter
import com.example.navdrawer.retroFitClients.RetrofitClient
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class FragmentUser : Fragment(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        launch {
            val users = getUserRetrofit()
            rvUser.layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )
            rvUser.adapter = UserAdapter(users)
        }
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    suspend fun getUserRetrofit(): List<User> {
        val userApi = RetrofitClient.UserApi

        val response = userApi.getUsers()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }

    }