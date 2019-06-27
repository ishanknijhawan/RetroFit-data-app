package com.example.navdrawer.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navdrawer.R
import com.example.navdrawer.adapters.todoAdapter
import com.example.navdrawer.modal.todoText
import com.example.navdrawer.retroFitClients.RetrofitClientTodos
import kotlinx.android.synthetic.main.fragment_todo.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class todoFragment : Fragment(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        launch {
            val todos = gettodos()
            rvTodo.layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )
            rvTodo.adapter = todoAdapter(todos)
        }
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    suspend fun gettodos(): List<todoText> {
        val todoApi = RetrofitClientTodos.todoApi

        val response = todoApi.gettodos()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }

}
