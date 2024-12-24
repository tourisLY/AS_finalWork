package com.example.fruitstore.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitstore.Adapter.ListGoodLeftAdapter.ViewHolder
import com.example.fruitstore.R

class OrderStateAdapter(val OrderStateList:List<String>) :RecyclerView.Adapter<OrderStateAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val OrderStateName: TextView = view.findViewById(R.id.order_list_state)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_order_state, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val orderState = OrderStateList[position]
        holder.OrderStateName.text = orderState.toString()
    }


    override fun getItemCount() = OrderStateList.size
}