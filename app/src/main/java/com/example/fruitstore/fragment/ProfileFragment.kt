package com.example.fruitstore.fragment

import android.accounts.Account
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.fruitstore.R
import com.example.fruitstore.databinding.FragmentProfileBinding
import com.example.fruitstore.entity.User
import com.example.fruitstore.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding:FragmentProfileBinding ?= null
    private val binding get() = _binding!!
    private lateinit var myIntent:Intent
    private lateinit var userAccount: String

    val userRepository = UserRepository()
    private lateinit var user: User

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentProfileBinding.bind(view)
        initButton()
        initView()
    }

    private fun initButton(){
        binding.balanceLayout.setOnClickListener{btBalance()}               //余额
        binding.orderLayout.setOnClickListener{btOrder()}                   //订单
        binding.rechargeLayout.setOnClickListener{btRecharge()}             //充值
        binding.ticketLayout.setOnClickListener{btTicket()}                 //卡券
        binding.addressLayout.setOnClickListener{btAddress()}               //地址
        binding.usLayout.setOnClickListener{btUs()}                         //我们
        binding.settingLayout.setOnClickListener{btSetting()}               //设置
    }

    private fun btBalance(){

    }
    private fun btRecharge(){

    }
    private fun btOrder(){

    }
    private fun btTicket(){

    }
    private fun btAddress(){

    }
    private fun btUs(){
        Toast.makeText(context, "women", Toast.LENGTH_SHORT).show()
    }
    private fun btSetting(){

    }

    private fun initView(){
        CoroutineScope(Dispatchers.Main).launch {
            try {

                val users:List<User> = userRepository.getUserByAccount(userAccount)
                if(users.isEmpty()){
                    Toast.makeText(context, "用户信息获取失败",Toast.LENGTH_SHORT).show()
                }else{
                    for(user in users){
                        binding.userName.text = user.userName
                        binding.balanceNum.text = user.userBalance.toString()
                        binding.userImg.setImageResource(resources.getIdentifier(user.userHead, "drawable", requireContext().packageName))
                    }
                }
            }catch (e:Exception){
                e.printStackTrace()
                Toast.makeText(context, "用户信息获取失败",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val inActivity = activity
        if(inActivity != null){
            myIntent = inActivity.intent
            userAccount = myIntent.getStringExtra("userAccount")?:"wrong"
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }
}