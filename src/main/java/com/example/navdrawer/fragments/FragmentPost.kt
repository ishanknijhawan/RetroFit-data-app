package com.example.navdrawer.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navdrawer.R
import com.example.navdrawer.adapters.PostAdapter
import com.example.navdrawer.api.PostApi
import com.example.navdrawer.modal.PostText
import com.example.navdrawer.retroFitClients.RetrofitClientPost
import kotlinx.android.synthetic.main.fragment_post.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class FragmentPost : Fragment(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        launch {
            val posts = getPostRetrofit()
            rvUserPost.layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )
            rvUserPost.adapter = PostAdapter(posts)
        }
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    suspend fun getPostRetrofit(): List<PostText> {
        val PostApi = RetrofitClientPost.PostApi

        val response = PostApi.getPosts()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }

}
