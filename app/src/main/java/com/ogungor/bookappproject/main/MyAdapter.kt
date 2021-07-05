package com.ogungor.bookappproject.main

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.ogungor.bookappproject.R
import com.ogungor.bookappproject.details.OceanFragment
import com.ogungor.bookappproject.details.OceanFragment2
import com.ogungor.bookappproject.details.OceanFragment3
import kotlinx.android.synthetic.main.card_item.view.*


class MyAdapter(
    private val context: Context,
    private val myModelArrayList: ArrayList<MyModel>,
    private val mainActivity: MainActivity
) :
    PagerAdapter() {

    override fun getCount(): Int {
        return myModelArrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false)

        val model = myModelArrayList[position]
        val image = model.image
        view.banner.setImageResource(image)

        view.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("ResourceType")
            override fun onClick(p0: View?) {
                mainActivity.apply {
                    when (position) {
                        0 -> {

                            onClickView(OceanFragment())
                        }
                        1 -> {
                            onClickView(OceanFragment2())
                        }
                        2 -> {
                            onClickView(OceanFragment3())
                        }
                    }
                }
            }
        })
        container.addView(view, position)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}