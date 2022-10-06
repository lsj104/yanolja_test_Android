package com.example.risingtest.src.main.myPage

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import com.example.risingtest.R
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.risingtest.config.ApplicationClass.Companion.sSharedPreferences
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentMyPageBinding
import com.example.risingtest.src.main.myPage.login.LogInActivityView
import com.example.risingtest.src.main.myPage.login.LogInResponse
import com.example.risingtest.src.main.search.reservation.ReservationActivity

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page) {

    val TOKEN = sSharedPreferences.getString(X_ACCESS_TOKEN,"")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!(TOKEN.equals(""))){
            binding.myLayoutLogin.visibility = View.INVISIBLE
            binding.myLayoutLogin2.visibility = View.VISIBLE
            binding.myTextPoint2.visibility = View.VISIBLE
            binding.myTextCoin2.visibility = View.VISIBLE
            binding.textMyCoupon2.visibility = View.VISIBLE
            binding.myTextUnsign.text="예약 내역"


        }



        binding.myBtnUp.setOnClickListener {
            binding.myScrollview.fullScroll(ScrollView.FOCUS_UP)

        }

        binding.reservationBtn.setOnClickListener {
            val intent = Intent(requireActivity(), ReservationActivity::class.java)
            startActivity(intent)
        }

        binding.myLayoutLogin.setOnClickListener{
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            startActivity(intent)
        }


    }

}