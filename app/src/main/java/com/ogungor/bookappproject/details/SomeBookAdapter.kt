package com.ogungor.bookappproject.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.bookappproject.R
import kotlinx.android.synthetic.main.populer_item.view.*

class SomeBookAdapter (private val someBooks:ArrayList<RecyclerModelSomeBook>):
    RecyclerView.Adapter<SomeBookAdapter.ViewHolder>() {

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view:View = LayoutInflater.from(parent.context).inflate(R.layout.recommeded_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SomeBookAdapter.ViewHolder, position: Int) {
       holder.imageView.setImageResource(someBooks[position].image)
    }

    override fun getItemCount(): Int= someBooks.size
}