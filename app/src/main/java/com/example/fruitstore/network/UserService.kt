package com.example.fruitstore.network

import com.example.fruitstore.entity.User
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {
    @GET("user/login")
    suspend fun  loginByAccount(@Query("userAccount")userAccount:String,@Query("userPassword")userPassword:String):Boolean

    @POST("user/registerUserByAccount")
    suspend fun registerUserByAccount(@Query("userAccount")userAccount: String, @Query("userPassword")userPassword: String):Boolean

    @GET("user/getByAccount")
    suspend fun getUserByAccount(@Query("userAccount")userAccount: String):List<User>
}