package com.example.fruitstore.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fruitstore.R
import com.example.fruitstore.databinding.ActivityBaseBinding
import com.example.fruitstore.databinding.ActivityMainBinding
import com.example.fruitstore.fragment.CartFragment
import com.example.fruitstore.fragment.HomeFragment
import com.example.fruitstore.fragment.OrderFragment
import com.example.fruitstore.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityMain: AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val fragmentManager = supportFragmentManager
//    private val homeFragment = HomeFragment()
//    private val cartFragment = CartFragment()
//    private val orderFragment = OrderFragment()
//    private val profileFragment = ProfileFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        getPermission()
        intent.putExtra("loginState", false)

    }

    override fun onStart() {
        super.onStart()
        initBottomNavigation()
    }

    private fun initView(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        fragmentManager.beginTransaction()
//            .replace(R.id.home_fragment, homeFragment)
//            .commit()
    }


    private fun initBottomNavigation(){                             //导航栏跳转
        val bottomNav: BottomNavigationView = binding.bottomNavigation
        val navController = findNavController(R.id.nav_host_fragment)
        bottomNav.setupWithNavController(navController)
      bottomNav.setOnNavigationItemSelectedListener { item ->
        navController.navigate(item.itemId) // 根据菜单项的 ID 执行导航
        true
    }
//        {
    //
    //        menuItem ->
//            when(menuItem.itemId){
//                R.id.nav_home->{
////                    startActivity(Intent(this, ActivityHome::class.java)
//                    if(fragmentManager.findFragmentById(R.id.home_fragment) is HomeFragment){
//                        Log.d("导航栏", "已在主页")
//                        bottomChange = true
//                    }else if(timeLimit >= 10){
//                        timeLimit = 0
//                        fragmentManager.beginTransaction()
//                            .replace(R.id.home_fragment, homeFragment)
//                            .commitAllowingStateLoss()
//                        bottomChange = true
//                    }else{
//                        bottomChange = false
//                    }
//
//                    bottomChange
//                }
//                R.id.nav_cart->{
////                    startActivity(Intent(this, ActivityCart::class.java))
//                    if(fragmentManager.findFragmentById(R.id.home_fragment) is CartFragment){
//                        Log.d("导航栏", "已在点单")
//                        bottomChange = true
//                    }else if(timeLimit >= 10){
//                        timeLimit = 0
//                        fragmentManager.beginTransaction()
//                            .replace(R.id.home_fragment, cartFragment)
//                            .commitAllowingStateLoss()
//                        bottomChange = true
//                    }else{
//                        bottomChange = false
//                    }
//                    bottomChange
//                }
//                R.id.nav_order->{
////                    startActivity(Intent(this, ActivityOrder::class.java))
//                    if(fragmentManager.findFragmentById(R.id.home_fragment) is OrderFragment){
//                        Log.d("导航栏", "已在订单")
//                        bottomChange = true
//                    }else if(timeLimit >= 10){
//                        timeLimit = 0
//                        fragmentManager.beginTransaction()
//                            .replace(R.id.home_fragment, orderFragment)
//                            .commitAllowingStateLoss()
//                        bottomChange = true
//                    }else{
//                        bottomChange = false
//                    }
//                    bottomChange
//                }
//                R.id.nav_profile->{
//                    if(fragmentManager.findFragmentById(R.id.home_fragment) is ProfileFragment){
//                        Log.d("导航栏", "已在我的")
//                        bottomChange = true
//                    }else if(timeLimit >= 10){
//                        timeLimit = 0
//                        fragmentManager.beginTransaction()
//                            .replace(R.id.home_fragment, profileFragment)
//                            .commitAllowingStateLoss()
//                        bottomChange = true
//                    }else{
//                        bottomChange = false
//                    }
//                    bottomChange
//                }
//
//                else -> false
//            }
//        }
//        bottomNav.selectedItemId = R.id.nav_home
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            1 ->{
                if(grantResults.isNotEmpty()&&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED){
                }else{
                    Toast.makeText(this,"You denied the permission",
                        Toast.LENGTH_SHORT).show()
                }
            }
            2->{
            }
        }
    }

    private fun getPermission(){
        val permissionList = ArrayList<String>()
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)!=
            PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.INTERNET)
        }
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_NETWORK_STATE)!=
            PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_NETWORK_STATE)
        }
        if(!permissionList.isEmpty()){
            ActivityCompat.requestPermissions(this,
                permissionList.toTypedArray(), 2)
        }
    }
}