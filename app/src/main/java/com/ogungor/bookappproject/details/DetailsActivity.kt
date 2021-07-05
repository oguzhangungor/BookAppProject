package com.ogungor.bookappproject.details

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.bookappproject.R
import com.ogungor.bookappproject.databinding.DetailsLayoutBinding
import kotlinx.android.synthetic.main.details_layout.*

class DetailsActivity : AppCompatActivity(){

    private lateinit var someBooks:ArrayList<RecyclerModelSomeBook>
    private lateinit var binding:DetailsLayoutBinding
    private lateinit var some_book_recyclerView: RecyclerView
    private lateinit var imageBanner:ImageView


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DetailsLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        some_book_recyclerView=binding.someBookRecyclerView
        imageBanner=binding.detailsImageView

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }

        val intent=intent
        val position=intent.getIntExtra("position",0)
        when (position){
            1-> {
                imageBanner.setImageResource(R.drawable.oceandetails)
            }
            2->{
                imageBanner.setImageResource(R.drawable.orange)
            }
        }
        someBooks=ArrayList()

        for (i in 1..2) {
            someBooks.add(RecyclerModelSomeBook(R.drawable.warlight))
            someBooks.add(RecyclerModelSomeBook(R.drawable.brother))
            someBooks.add(RecyclerModelSomeBook(R.drawable.country))
        }
        some_book_recyclerView.layoutManager=
            LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)
        some_book_recyclerView.adapter=SomeBookAdapter(someBooks)
    }
}