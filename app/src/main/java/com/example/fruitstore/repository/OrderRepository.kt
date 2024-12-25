package com.example.fruitstore.repository

import com.example.fruitstore.entity.Order
import com.example.fruitstore.entity.OrderItem
import com.example.fruitstore.instance.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OrderRepository {
    suspend fun getAllOrders(userId:Int):List<Order>
    {
        return  withContext(Dispatchers.IO){
            RetrofitInstance.orderapi.getAllOrders(userId)
        }
    }

    suspend fun getOrderByState(orderState:String, userId: Int):List<Order>
    {
        return withContext(Dispatchers.IO){
            RetrofitInstance.orderapi.getOrdersByState(orderState, userId)
        }
    }

    suspend fun getAllOrderItems(orderId:Int):List<OrderItem>
    {
        return withContext(Dispatchers.IO){
            RetrofitInstance.orderapi.getAllOrderItems(orderId)
        }
    }
}