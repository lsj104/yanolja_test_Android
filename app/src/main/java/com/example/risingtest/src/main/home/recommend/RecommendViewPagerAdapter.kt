package com.example.risingtest.src.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.R
import kotlinx.android.synthetic.main.fragment_recommend.view.*
import kotlinx.android.synthetic.main.recommend_ad_list.view.*

class RecommendViewPagerAdapter(getImgList: ArrayList<Int>): RecyclerView.Adapter<RecommendViewPagerAdapter.PagerViewHolder>(){
    var item = getImgList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewPagerAdapter.PagerViewHolder = PagerViewHolder((parent))


    override fun onBindViewHolder(holder: RecommendViewPagerAdapter.PagerViewHolder, position: Int) {
        holder.banner.setImageResource(item[position%6])
    }

    override fun getItemCount(): Int  = Int.MAX_VALUE

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.recommend_ad_list, parent, false)){

        val banner = itemView.recommend_viewPager_imgView!!
    }
}