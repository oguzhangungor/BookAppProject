package com.ogungor.bookappproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var posts: ArrayList<String>

    private lateinit var myModelList:ArrayList<MyModel>

    private lateinit var myAdapter: MyAdapter

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadCards()

        posts= ArrayList()


        for (i in 1..5){
            posts.add("Post # $i")
        }
        recyclerView.layoutManager= LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)
        recyclerView.adapter= PostsAdapter(posts)

    }

    private fun loadCards() {
        myModelList= ArrayList()

        myModelList.add(MyModel(R.drawable.ocean))

    myAdapter= MyAdapter(this,myModelList)

        viewPager.adapter=myAdapter
    }
}