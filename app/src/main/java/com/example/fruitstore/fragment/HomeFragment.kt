package com.example.fruitstore.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    private lateinit var myIntent: Intent
    private  var loginState:Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)

        initButton()
    }

    private fun initButton(){
        binding.btTest.setOnClickListener{
            Toast.makeText(context, "$loginState", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val inActivity = activity
        if(inActivity != null){
            myIntent = inActivity.intent
            loginState = myIntent.getBooleanExtra("loginState",false)
        }
    }
}