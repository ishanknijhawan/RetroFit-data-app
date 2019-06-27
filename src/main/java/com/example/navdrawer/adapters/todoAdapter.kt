package com.example.navdrawer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navdrawer.R
import com.example.navdrawer.modal.todoText
import kotlinx.android.synthetic.main.layout_todo.view.*

class todoAdapter (private val todos:List<todoText>):
    RecyclerView.Adapter<todoAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val li4 = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view4 = li4.inflate(R.layout.layout_todo,parent,false)
        return ViewHolder(view4)
    }

    override fun getItemCount() = todos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todos[position]
        holder.bind(todo)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(todo: todoText){

            with(itemView){
                tvIdtodo.text = todo.id.toString()
                tvTitletodo.text = todo.title
                tvCompletedTodo.text = todo.completed.toString()
            }

        }

    }
}