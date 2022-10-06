package com.example.risingtest.src.main.search

import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySearchBinding
import com.google.android.material.tabs.TabLayout


class SearchActivity : BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate) {

    lateinit var tab1: SearchDomesticFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tab1 = SearchDomesticFragment()

        supportFragmentManager.beginTransaction().add(R.id.search_container, tab1).commit()

        binding.searchTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> {
                        replaceView(tab1)
                    }

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

    private fun replaceView(tab: Fragment) {

        var selectedFragment: Fragment?=null
        selectedFragment = tab
        selectedFragment?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.login_container,it).commit()
        }

    }


}