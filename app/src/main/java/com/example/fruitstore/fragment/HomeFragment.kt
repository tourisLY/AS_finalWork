package com.example.fruitstore.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fruitstore.R
import com.example.fruitstore.databinding.FragmentHomeBinding
import com.example.fruitstore.entity.GoodLeft
import com.example.fruitstore.repository.GoodLeftRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding:FragmentHomeBinding ?= null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)

        initButton()
    }

    private fun initButton(){

    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }

}