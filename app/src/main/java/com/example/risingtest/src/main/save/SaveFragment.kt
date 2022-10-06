package com.example.risingtest.src.main.save

import android.os.Bundle
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentSaveBinding

class SaveFragment : BaseFragment<FragmentSaveBinding>(FragmentSaveBinding::bind, R.layout.fragment_location) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showCustomToast("환영합니다.")
    }
}