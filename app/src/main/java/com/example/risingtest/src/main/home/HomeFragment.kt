package com.example.risingtest.src.main.home

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentHomeBinding
import com.example.risingtest.src.main.MainActivity
import com.example.risingtest.src.main.home.`fun`.FunFragment
import com.example.risingtest.src.main.home.abroad.AbroadFragment
import com.example.risingtest.src.main.home.domestic.DomesticFragment
import com.example.risingtest.src.main.home.recommend.RecommendFragment
import com.example.risingtest.src.main.home.traffic.TrafficFragment
import com.example.risingtest.src.main.myPage.FragmentAdapter
import com.example.risingtest.src.main.search.SearchActivity
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentList = listOf(
            RecommendFragment(),
            DomesticFragment(),
            FunFragment(),
            TrafficFragment(),
            AbroadFragment()
        )
        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList
        binding.loginViewPager.adapter = adapter

        val tabTitles = listOf<String>("추천", "국내숙소", "즐길거리", "교통/항공", "해외여행")
        TabLayoutMediator(binding.tabLayout, binding.loginViewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        binding.loginViewPager.isUserInputEnabled = false

        binding.recommendSearch.setOnClickListener {
            val intent = Intent(requireActivity(), SearchActivity::class.java)
            startActivity(intent)
        }

    }




}