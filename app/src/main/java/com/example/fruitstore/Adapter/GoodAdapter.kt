package com.example.fruitstore.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitstore.R
import com.example.fruitstore.entity.Good

class GoodAdapter(val GoodList:List<Good>):RecyclerView.Adapter<GoodAdapter.ViewHolder>()
{
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val goodImage:ImageView = view.findViewById(R.id.good_right_img)//TODO 这个东西因为图片的src都是乱输的，所以暂时先不用
        val goodName:TextView = view.findViewById(R.id.good_right_name)
        val goodMsg:TextView = view.findViewById(R.id.good_right_msg)
        val goodRealPrice:TextView = view.findViewById(R.id.list_good_right_in_cart_real_price)
        val goodEarlyPrice:TextView = view.findViewById(R.id.list_good_right_in_cart_early_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_good_right_in_cart, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = GoodList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listGood = GoodList[position]
//        TODO 下面这个是图片的东西，但是因为还没弄好，所以先注释了
//        holder.goodImage.setImageResource(listGood.)
        holder.goodName.text = listGood.goodName
        holder.goodMsg.text = listGood.goodMsg
        holder.goodRealPrice.text = listGood.goodPrice.toString()
//        TODO 其实还有关于优惠价原价的东西，但是目前在测试，之后再完成
    }
}