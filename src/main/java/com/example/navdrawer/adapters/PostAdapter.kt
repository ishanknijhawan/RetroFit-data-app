package com.example.navdrawer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navdrawer.R
import com.example.navdrawer.modal.PostText
import kotlinx.android.synthetic.main.layout_post.view.*

class PostAdapter(private val posts:List<PostText>):
    RecyclerView.Adapter<PostAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val li2 = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view2 = li2.inflate(R.layout.layout_post,parent,false)
        return ViewHolder(view2)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(post: PostText){

            with(itemView){
                tvID.text = post.id.toString()
                tvTitle.text = post.title
                tvBody.text = post.body
            }

        }

    }
}