package com.example.risingtest.src.main.test

import android.os.Bundle
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentTestBinding

class TestFragment: BaseFragment<FragmentTestBinding>(FragmentTestBinding::bind, R.layout.fragment_test) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showCustomToast("환영합니다.")
    }
}