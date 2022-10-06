package com.example.risingtest.src.main.myPage.signup

import android.os.Bundle
import android.widget.CompoundButton
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.BottomSheetDialogBinding

class ActivityTermAgree: BaseActivity<BottomSheetDialogBinding>(BottomSheetDialogBinding::inflate) {

    var AllAgree = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.dialogCheckAll.setOnClickListener {
            if (AllAgree == false) {
                AllAgree == true
                binding.dialogCheck1st.isChecked = true
                binding.dialogCheck2nd.isChecked = true
                binding.dialogCheck3rd.isChecked = true
                binding.dialogCheck4th.isChecked = true

            }
        }
    }


}