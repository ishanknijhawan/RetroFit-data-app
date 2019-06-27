package com.example.navdrawer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navdrawer.R
import com.example.navdrawer.modal.commentsText
import kotlinx.android.synthetic.main.layout_comment.view.*
import kotlinx.android.synthetic.main.layout_comment.view.*

class CommentsAdapter(private val comments:List<commentsText>):
    RecyclerView.Adapter<CommentsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val li3 = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view3 = li3.inflate(R.layout.layout_comment,parent,false)
        return ViewHolder(view3)
    }

    override fun getItemCount() = comments.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = comments[position]
        holder.bind(comment)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(comment: commentsText){

            with(itemView){
                tvNameComment.text = comment.name
                tvBodyComment.text = comment.body
                tvEmailComment.text = comment.email
            }

        }

    }
}