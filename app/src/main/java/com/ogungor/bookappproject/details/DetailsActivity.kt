package com.ogungor.bookappproject.details

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.ogungor.bookappproject.R
import kotlinx.android.synthetic.main.details_layout.*

class DetailsActivity : AppCompatActivity(){

    private lateinit var someBooks:ArrayList<RecyclerModelSomeBook>

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_layout)

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