package com.example.fruitstore.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitstore.R
import com.example.fruitstore.entity.Good
import com.example.fruitstore.entity.GoodLeft
import com.example.fruitstore.instance.RetrofitInstance
import com.example.fruitstore.repository.GoodsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListGoodRightAdapter (val GoodLeftList:List<GoodLeft>):RecyclerView.Adapter<ListGoodRightAdapter.ViewHolder>()
{
    val goodsRepository = GoodsRepository()
    lateinit var goodAdapter: GoodAdapter

   inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
       val goodClassify: TextView = view.findViewById(R.id.list_good_right_name)
       val innerRecyclerView:RecyclerView = view.findViewById(R.id.good_right_list_msg)

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_good_right, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = GoodLeftList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listGoodRightBig = GoodLeftList[position]
        holder.goodClassify.text = listGoodRightBig.goodClassify

        var innerGoodMsgList = mutableListOf<Good>()
        holder.innerRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.innerRecyclerView.isNestedScrollingEnabled = false

        CoroutineScope(Dispatchers.Main).launch {
            try {
                innerGoodMsgList.addAll(goodsRepository.getGoodsById(listGoodRightBig.goodClassifyId))
                goodAdapter = GoodAdapter(innerGoodMsgList)
                holder.innerRecyclerView.adapter = goodAdapter
                goodAdapter.notifyDataSetChanged()


            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}