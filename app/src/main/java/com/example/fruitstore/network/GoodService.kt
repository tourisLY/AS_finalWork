package com.example.fruitstore.network

import com.example.fruitstore.entity.Good
import retrofit2.http.GET
import retrofit2.http.Query

interface GoodService {
    @GET("goods")
    suspend fun getAllGoods():List<Good>

    @GET("goods/byClassifyId")
    suspend fun getGoodByClassifyId(@Query("ClassifyId")classifyId:Int):List<Good>
}