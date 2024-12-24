package com.example.fruitstore.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fruitstore.databinding.ActivityUserBinding

class ActivityUser:AppCompatActivity() {
    private lateinit var binding:ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initBt()
    }

    private fun initView(){
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initBt(){}
}