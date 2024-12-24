package com.example.fruitstore.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitstore.Adapter.ImageSliderAdapter
import com.example.fruitstore.Adapter.ListGoodLeftAdapter
import com.example.fruitstore.Adapter.ListGoodRightAdapter
import com.example.fruitstore.R
import com.example.fruitstore.databinding.FragmentCartBinding
import com.example.fruitstore.entity.GoodLeft
import com.example.fruitstore.repository.GoodLeftRepository
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CartFragment : Fragment(R.layout.fragment_cart) {

    private var _binding:FragmentCartBinding ?= null
    private val binding get() = _binding!!
    private lateinit var imageAdapter: ImageSliderAdapter
    private val GoodLeftRepository = GoodLeftRepository()
    private lateinit var goodLeftAdapter:ListGoodLeftAdapter
    private lateinit var goodRightAdapter: ListGoodRightAdapter
    //列表数据
    private var goodLeftList = mutableListOf<GoodLeft>()
//    private val goodTitle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCartBinding.bind(view)

        initViewPager2()
        initList()


    }


//    初始化顶部滚动广告栏
    private fun initViewPager2(){
        val images = listOf(
            R.drawable.rounded_image,
            R.drawable.menu,
            R.drawable.profile_img
        )
        imageAdapter = ImageSliderAdapter(images)
        binding.cartImageSlide.adapter = imageAdapter

        // 配置 TabLayout 和 ViewPager2 进行联动，去掉 tab.text
//        TabLayoutMediator(binding.tabLayout, binding.cartImageSlide) { _, _ ->
//            // 不设置tab的文字，这样就只会显示小点作为指示器
//        }.attach()

        binding.cartImageSlide.postDelayed(object : Runnable {
            override fun run() {
                val nextItem = (binding.cartImageSlide.currentItem + 1) % imageAdapter.itemCount
                binding.cartImageSlide.setCurrentItem(nextItem, true)
                binding.cartImageSlide.postDelayed(this, 3000) // 每3秒切换一次
            }
        }, 3000) // 初始延迟

    }


//    初始化商品列表
    private fun initList(){
        binding.listGoodTitle.layoutManager = LinearLayoutManager(context)
        binding.listGoodRight.layoutManager = LinearLayoutManager(context)


        CoroutineScope(Dispatchers.Main).launch {
            try {
//               这里开始加载左侧大栏
                goodLeftList.addAll(GoodLeftRepository.getAllGoodLeft())
                Log.d("aaa", "${goodLeftList.size}")
                goodLeftAdapter = ListGoodLeftAdapter(goodLeftList)
                binding.listGoodTitle.adapter = goodLeftAdapter


//                CoroutineScope
//                左侧大栏加载完毕，加载右侧大栏
                goodRightAdapter = ListGoodRightAdapter(goodLeftList)
                binding.listGoodRight.adapter = goodRightAdapter
                goodLeftAdapter.notifyDataSetChanged()
                goodRightAdapter.notifyDataSetChanged()
//                右侧大栏加载完毕,加载右侧大栏里面的商品
            }catch (e:Exception){
                e.printStackTrace()
                Toast.makeText(context, "获取分类信息失败！",Toast.LENGTH_SHORT ).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }
}