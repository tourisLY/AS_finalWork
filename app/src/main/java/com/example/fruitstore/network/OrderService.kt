package com.example.fruitstore.network

import com.example.fruitstore.entity.Order
import com.example.fruitstore.entity.OrderItem
import retrofit2.http.GET
import retrofit2.http.Query

interface OrderService {
    @GET("order/byOrderState")
    suspend fun getOrdersByState(@Query("orderState")orderState:String, @Query("userId")userId: Int):List<Order>

    @GET("order/getAllOrderItems")
    suspend fun getAllOrderItems(@Query("orderId")orderId:Int):List<OrderItem>

    @GET("/order")
    suspend fun getAllOrders(@Query("userId")userId:Int):List<Order>
}