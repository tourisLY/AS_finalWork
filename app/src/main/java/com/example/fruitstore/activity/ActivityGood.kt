package com.example.fruitstore.activity

import android.os.Bundle
import com.example.fruitstore.databinding.ActivityGoodBinding

class ActivityGood:BaseActivity() {

    private lateinit var binding:ActivityGoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}