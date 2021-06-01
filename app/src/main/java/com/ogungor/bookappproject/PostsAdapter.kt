package com.ogungor.bookappproject

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostsAdapter( val posts: ArrayList<String>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {



    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val popularTextView:TextView=itemView.findViewById(R.id.populer_textview_title)
        //val imageView:ImageView=itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view:View= LayoutInflater.from(parent.context).inflate(R.layout.populer_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.popularTextView.text="Vegan Atletic"
        //holder.imageView.setImageResource(R.drawable.mask)
    }

    override fun getItemCount()= posts.size

}
