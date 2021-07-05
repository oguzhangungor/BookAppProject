package com.ogungor.bookappproject.main

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ogungor.bookappproject.R
import com.ogungor.bookappproject.databinding.ActivityMainBinding
import com.ogungor.bookappproject.details.OceanFragment

class MainActivity : AppCompatActivity() {

    private lateinit var popularPosts: ArrayList<RecyclerModel>
    private lateinit var recommendedPosts: ArrayList<RecyclerModel>

    private lateinit var myModelList: ArrayList<MyModel>
    private lateinit var bottom_nav: BottomNavigationView
    private lateinit var myAdapter: MyAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewRecommend: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentTransaction: FragmentTransaction
    private lateinit var fragmentt: Fragment

    private lateinit var ellipseOne: ImageView
    private lateinit var ellipseTwo: ImageView
    private lateinit var ellipseThree: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        bottom_nav = binding.bottomNav
        viewPager = binding.viewPager
        ellipseOne = binding.ellipseOne
        ellipseThree = binding.ellipseThree
        ellipseTwo = binding.ellipseTwo
        recyclerView = binding.recyclerView
        recyclerViewRecommend = binding.recyclerViewRecommend
        popularPosts = ArrayList()
        recommendedPosts = ArrayList()
        fragmentTransaction = supportFragmentManager.beginTransaction()

        loadCards()
        loadPopularPosts()
        loadRecommendPosts()

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        ellipseOne.setImageResource(R.drawable.ellipse_red)
                        ellipseTwo.setImageResource(R.drawable.ellipse_whitee)
                        ellipseThree.setImageResource(R.drawable.ellipse_whitee)
                    }
                    1 -> {
                        ellipseOne.setImageResource(R.drawable.ellipse_whitee)
                        ellipseTwo.setImageResource(R.drawable.ellipse_red)
                        ellipseThree.setImageResource(R.drawable.ellipse_whitee)
                    }
                    2 -> {
                        ellipseOne.setImageResource(R.drawable.ellipse_whitee)
                        ellipseTwo.setImageResource(R.drawable.ellipse_whitee)
                        ellipseThree.setImageResource(R.drawable.ellipse_red)
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    @SuppressLint("WrongConstant")
    private fun loadRecommendPosts() {
        for (i in 1..2) {
            recommendedPosts.add(RecyclerModel(R.drawable.cottage, " ", ""))
            recommendedPosts.add(RecyclerModel(R.drawable.shadowless, " ", ""))
            recommendedPosts.add(RecyclerModel(R.drawable.vegan, " ", ""))
        }


        recyclerViewRecommend.layoutManager =
            LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerViewRecommend.adapter = PostsAdapter(recommendedPosts)
    }

    @SuppressLint("WrongConstant")
    private fun loadPopularPosts() {
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
    }

    private fun loadCards() {
        myModelList = ArrayList()

        myModelList.add(MyModel(R.drawable.oceans))
        myModelList.add(MyModel(R.drawable.orange))
        myModelList.add(MyModel(R.drawable.vegan))

        myAdapter = MyAdapter(this, myModelList, this)
        viewPager.adapter = myAdapter
    }

    fun onClickView(fragment: Fragment) {
        bottom_nav.isVisible = false
        fragmentTransaction.add(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var framelayout = binding.frameLayout
        framelayout.isVisible = false

    }

}