package com.example.fruitstore.repository

import com.example.fruitstore.entity.User
import com.example.fruitstore.instance.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    suspend fun loginByAccount(userAccount:String, userPassword:String):Boolean
    {
        return withContext(Dispatchers.IO){
            RetrofitInstance.userapi.loginByAccount(userAccount,userPassword)
        }
    }

    suspend fun registerUserByAccount(userAccount: String, userPassword: String):Boolean
    {
        return withContext(Dispatchers.IO){
            RetrofitInstance.userapi.registerUserByAccount(userAccount, userPassword)
        }
    }

    suspend fun getUserByAccount(userAccount:String):List<User>
    {
        return withContext(Dispatchers.IO){
            RetrofitInstance.userapi.getUserByAccount(userAccount)
        }
    }

    suspend fun updateUserName(userId:Int, userName:String):Boolean
    {
        return withContext(Dispatchers.IO){
            RetrofitInstance.userapi.updateUserName(userId, userName)
        }
    }
}