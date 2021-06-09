package com.ogungor.bookappproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var popularPosts: ArrayList<RecyclerModel>
    private lateinit var recommendedPosts: ArrayList<RecyclerModel>

    private lateinit var myModelList:ArrayList<MyModel>

    private lateinit var myAdapter: MyAdapter

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadCards()

        popularPosts= ArrayList()
        recommendedPosts= ArrayList()


        for (i in 1..2){
            popularPosts.add(RecyclerModel(R.drawable.sally,"Conversations with ","by Sally Rooney"))
            popularPosts.add(RecyclerModel(R.drawable.orange,"This Is How It Always is", "by Laurie Frankel"))
            popularPosts.add(RecyclerModel(R.drawable.teaspoon,"A Teaspoon of Earth and sea", "by Dina Nayeri"))
        }
        recyclerView.layoutManager= LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)
        recyclerView.adapter= PostsAdapter(popularPosts)

        for (i in 1..2){
            recommendedPosts.add(RecyclerModel(R.drawable.cottage," ",""))
            recommendedPosts.add(RecyclerModel(R.drawable.shadowless," ",""))
            recommendedPosts.add(RecyclerModel(R.drawable.vegan," ",""))
        }


        recyclerView_recommen.layoutManager= LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)
        recyclerView_recommen.adapter= PostsAdapter(recommendedPosts)

    }

    private fun loadCards() {
        myModelList= ArrayList()

        myModelList.add(MyModel(R.drawable.mask))

        myAdapter= MyAdapter(this,myModelList)

        viewPager.adapter=myAdapter
    }
}