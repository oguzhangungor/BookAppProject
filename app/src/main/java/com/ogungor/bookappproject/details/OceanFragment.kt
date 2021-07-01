package com.ogungor.bookappproject.details

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.bookappproject.R
import com.ogungor.bookappproject.databinding.FragmentOceanBinding
import com.ogungor.bookappproject.main.MainActivity


class OceanFragment : Fragment(R.layout.fragment_ocean) {

    private lateinit var someBooks: ArrayList<RecyclerModelSomeBook>
    private  var _binding: FragmentOceanBinding?=null
    private val binding get() = _binding!!
    private lateinit var someBookRecyclerView: RecyclerView
    private lateinit var imageBanner: ImageView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentOceanBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        someBookRecyclerView = binding.someBookRecyclerView
        imageBanner = binding.detailsImageView

        someBooks = ArrayList()

        for (i in 1..2) {
            someBooks.add(RecyclerModelSomeBook(R.drawable.warlight))
            someBooks.add(RecyclerModelSomeBook(R.drawable.brother))
            someBooks.add(RecyclerModelSomeBook(R.drawable.country))
        }

        someBookRecyclerView.layoutManager =
            LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)
        someBookRecyclerView.adapter = SomeBookAdapter(someBooks)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}
