package com.example.risingtest.src.main.nearbyme

import android.os.Bundle
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentNearbymeBinding

class NearByMeFragment : BaseFragment<FragmentNearbymeBinding>(FragmentNearbymeBinding::bind, R.layout.fragment_location) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showCustomToast("환영합니다.")
    }
}