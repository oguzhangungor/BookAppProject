package com.ogungor.bookappproject.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.bookappproject.R

class PostsAdapter(private val posts: ArrayList<RecyclerModel>) :
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val popularTextView: TextView = itemView.findViewById(R.id.populer_textview_title)
        val popularTextViewWriter: TextView = itemView.findViewById(R.id.populer_textview_writer)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.populer_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.popularTextView.text = posts[position].title
        holder.popularTextViewWriter.text = posts[position].writer
        holder.imageView.setImageResource(posts[position].image)

    }

    override fun getItemCount() = posts.size

}
