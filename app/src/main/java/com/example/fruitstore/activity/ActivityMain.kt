package com.example.fruitstore.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
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
        if(savedInstanceState != null){
            intent.putExtra("userAccount", savedInstanceState.getString("userAccount"))
            intent.putExtra("loginState", savedInstanceState.getBoolean("loginState"))
        }
        initView()
        getPermission()
//        intent.putExtra("loginState", false)

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

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("userAccount", intent.getStringExtra("userAccount"))
        outState.putBoolean("loginState", intent.getBooleanExtra("loginState", false))
    }
}