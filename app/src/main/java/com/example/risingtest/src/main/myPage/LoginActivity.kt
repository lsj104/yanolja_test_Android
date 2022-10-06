package com.example.risingtest.src.main.myPage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TabHost
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityLoginBinding
import com.example.risingtest.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {


    lateinit var tab1: LoginFragment
    lateinit var tab2: SocialLoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        tab1 = LoginFragment()
        tab2 = SocialLoginFragment()

        supportFragmentManager.beginTransaction().add(R.id.login_container, tab1).commit()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> {
                        replaceView(tab1)
                    }

                    1 -> {
                        replaceView(tab2)
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