package com.example.navdrawer.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navdrawer.R
import com.example.navdrawer.adapters.CommentsAdapter
import com.example.navdrawer.modal.commentsText
import com.example.navdrawer.retroFitClients.RetrofitClientComments
import kotlinx.android.synthetic.main.fragment_fragment_comment.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class FragmentComment : Fragment(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        launch {
            val comments = getCommentRetrofit()
            rvUserComments.layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )
            rvUserComments.adapter = CommentsAdapter(comments)
        }
        return inflater.inflate(R.layout.fragment_fragment_comment, container, false)
    }

    suspend fun getCommentRetrofit(): List<commentsText> {
        val commentsApi = RetrofitClientComments.commentsApi

        val response = commentsApi.getComments()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }

}
