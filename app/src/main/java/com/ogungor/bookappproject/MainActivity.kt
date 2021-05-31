package com.ogungor.bookappproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.core.view.setPadding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var actionBar:ActionBar

    private lateinit var myModelList:ArrayList<MyModel>

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        loadCards()

    }

    private fun loadCards() {
        myModelList= ArrayList()

        myModelList.add(MyModel(R.drawable.bell))
        myModelList.add(MyModel(R.drawable.mask))
        myModelList.add(MyModel(R.drawable.user))

    myAdapter= MyAdapter(this,myModelList)

        viewPager.adapter=myAdapter

        viewPager.setPadding(100,0,100,0)
    }
}