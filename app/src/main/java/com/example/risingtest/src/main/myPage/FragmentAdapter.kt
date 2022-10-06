package com.example.risingtest.src.main.myPage

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.risingtest.src.main.home.HomeFragment

class FragmentAdapter(fragmentActivity: HomeFragment): FragmentStateAdapter(fragmentActivity) {

    var fragmentList = listOf<Fragment>()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}