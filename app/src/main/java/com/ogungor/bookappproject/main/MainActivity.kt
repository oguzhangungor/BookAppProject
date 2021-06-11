package com.ogungor.bookappproject.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.viewpager.widget.ViewPager
import com.ogungor.bookappproject.R
import com.ogungor.bookappproject.details.DetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.populer_item.*

class MainActivity : AppCompatActivity() {


    private lateinit var popularPosts: ArrayList<RecyclerModel>
    private lateinit var recommendedPosts: ArrayList<RecyclerModel>

    private lateinit var myModelList: ArrayList<MyModel>

    private lateinit var myAdapter: MyAdapter
    private lateinit var viewPager: ViewPager

    private lateinit var image:ImageView

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        image=findViewById(R.id.ellipse_white)

        loadCards()
        onClickDetails()
        popularPosts = ArrayList()
        recommendedPosts = ArrayList()


        for (i in 1..2) {
            popularPosts.add(
                RecyclerModel(
                    R.drawable.sally,
                    "Conversations with ",
                    "by Sally Rooney"
                )
            )
            popularPosts.add(
                RecyclerModel(
                    R.drawable.orange,
                    "This Is How It Always is",
                    "by Laurie Frankel"
                )
            )
            popularPosts.add(
                RecyclerModel(
                    R.drawable.teaspoon,
                    "A Teaspoon of Earth and sea",
                    "by Dina Nayeri"
                )
            )
        }
        recyclerView.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView.adapter = PostsAdapter(popularPosts)

        for (i in 1..2) {
            recommendedPosts.add(RecyclerModel(R.drawable.cottage, " ", ""))
            recommendedPosts.add(RecyclerModel(R.drawable.shadowless, " ", ""))
            recommendedPosts.add(RecyclerModel(R.drawable.vegan, " ", ""))
        }


        recyclerView_recommen.layoutManager =
            LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView_recommen.adapter = PostsAdapter(recommendedPosts)


    }

    private fun loadCards() {
        myModelList = ArrayList()

        myModelList.add(MyModel(R.drawable.oceans))
        myModelList.add(MyModel(R.drawable.orange))

        myAdapter = MyAdapter(this, myModelList)

        viewPager.adapter = myAdapter
    }

    private fun onClickDetails() {
        image.setOnClickListener {
            var intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)

        }
    }
}