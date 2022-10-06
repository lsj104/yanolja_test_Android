package com.example.risingtest.src.main.home.recommend

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class RecommendAdapter(fragmentActivity: RecommendFragment): FragmentStateAdapter(fragmentActivity) {

    var fragmentList = listOf<Fragment>()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}