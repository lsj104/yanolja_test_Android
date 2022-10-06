package com.example.risingtest.src.main.location

import android.os.Bundle
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentLocationBinding

class LocationFragment: BaseFragment<FragmentLocationBinding>(FragmentLocationBinding::bind, R.layout.fragment_location) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showCustomToast("환영합니다.")
    }
}