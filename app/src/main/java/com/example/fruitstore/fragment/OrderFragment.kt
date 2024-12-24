package com.example.fruitstore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitstore.Adapter.OrderStateAdapter
import com.example.fruitstore.R
import com.example.fruitstore.databinding.FragmentOrderBinding


class OrderFragment : Fragment(R.layout.fragment_order) {
    private var _binding:FragmentOrderBinding ?= null
    private val binding get() = _binding!!

    private val orderStateList = ArrayList<String>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding  = FragmentOrderBinding.bind(view)

        initOrderStateAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }

    private fun initOrderState(){
        orderStateList.add("全部订单")
        orderStateList.add("待付款")
        orderStateList.add("待成团")
        orderStateList.add("进行中")
        orderStateList.add("已结束")
//        orderStateList.add("")
    }

    private fun initOrderStateAdapter(){
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.orderState.layoutManager = layoutManager
        initOrderState()
        val orderStateAdapter = OrderStateAdapter(orderStateList)
        binding.orderState.adapter = orderStateAdapter
    }
}