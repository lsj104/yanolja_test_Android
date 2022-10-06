package com.example.risingtest.src.main

import android.os.Bundle
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityMainBinding
import com.example.risingtest.src.main.home.HomeFragment
import com.example.risingtest.src.main.myPage.MyPageFragment
import com.example.risingtest.src.main.location.LocationFragment
import com.example.risingtest.src.main.nearbyme.NearByMeFragment
import com.example.risingtest.src.main.save.SaveFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var index = intent.getIntExtra("fragmentPosition", 0)
        when(index){
            0 -> {supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
            binding.mainBtmNav.menu.getItem(0).isChecked = true}
            1 -> {supportFragmentManager.beginTransaction().replace(R.id.main_frm, LocationFragment()).commitAllowingStateLoss()
                binding.mainBtmNav.menu.getItem(1).isChecked = true}
            2 -> {supportFragmentManager.beginTransaction().replace(R.id.main_frm, NearByMeFragment()).commitAllowingStateLoss()
                binding.mainBtmNav.menu.getItem(2).isChecked = true}
            3 ->{supportFragmentManager.beginTransaction().replace(R.id.main_frm, SaveFragment()).commitAllowingStateLoss()
                binding.mainBtmNav.menu.getItem(3).isChecked = true}
            4 -> {supportFragmentManager.beginTransaction().replace(R.id.main_frm, MyPageFragment()).commitAllowingStateLoss()
                binding.mainBtmNav.menu.getItem(4).isChecked = true}


        }




        binding.mainBtmNav.setOnNavigationItemSelectedListener(
                BottomNavigationView.OnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.menu_main_btm_nav_home -> {
                            supportFragmentManager.beginTransaction()
                                    .replace(R.id.main_frm, HomeFragment())
                                    .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                        R.id.menu_main_btm_nav_location -> {
                            supportFragmentManager.beginTransaction()
                                    .replace(R.id.main_frm, LocationFragment())
                                    .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }

                        R.id.menu_main_btm_nav_nearbyme-> {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, NearByMeFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }

                        R.id.menu_main_btm_nav_mypage-> {
                            supportFragmentManager.beginTransaction()
                                    .replace(R.id.main_frm, MyPageFragment())
                                    .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }

                        R.id.menu_main_btm_nav_save-> {
                            supportFragmentManager.beginTransaction()
                                    .replace(R.id.main_frm, SaveFragment())
                                    .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                    false
                })
    }
}