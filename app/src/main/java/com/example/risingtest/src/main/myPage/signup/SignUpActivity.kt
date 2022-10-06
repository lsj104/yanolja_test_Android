package com.example.risingtest.src.main.myPage.signup


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.signupEdtId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (binding.signupEdtId.length() > 4) {
                    binding.signupBtnNext.visibility = View.INVISIBLE
                    binding.signupBtnNextPink.visibility = View.VISIBLE
                    binding.signupBtnNextPink.isClickable = true
                }else{
                    binding.signupBtnNext.visibility = View.VISIBLE
                    binding.signupBtnNextPink.visibility = View.INVISIBLE
                }

            }
            override fun afterTextChanged(s: Editable?) {


            }
        })

        binding.signupEdtPwConfirm2.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(binding.signupEdtPw2.getText().toString().equals(binding.signupEdtPwConfirm2.getText().toString())){
                    binding.signupBtnConfirm.visibility = View.INVISIBLE
                    binding.signupBtnConfirmPink.visibility = View.VISIBLE
                    binding.signupBtnConfirmPink.isClickable = true
                }else{
                    binding.signupBtnConfirm.visibility = View.VISIBLE
                    binding.signupBtnConfirmPink.visibility = View.INVISIBLE
                }

            }

            override fun afterTextChanged(s: Editable?) {

                if(binding.signupEdtPw2.getText().toString().equals(binding.signupEdtPwConfirm2.getText().toString())){
                    binding.signupBtnConfirm.visibility = View.INVISIBLE
                    binding.signupBtnConfirmPink.visibility = View.VISIBLE
                    binding.signupBtnConfirmPink.isClickable = true
                }else{
                    binding.signupBtnConfirm.visibility = View.VISIBLE
                    binding.signupBtnConfirmPink.visibility = View.INVISIBLE
                }

            }

        })

        binding.signupEdtPw2.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {



            }

            override fun afterTextChanged(s: Editable?) {


            }

        })

        binding.signupBtnNextPink.setOnClickListener{
            binding.signupEdtPw.visibility = View.VISIBLE
            binding.signupEdtPw.error = "영문+숫자+특수문자 8~20자리"
            binding.signupEdtPwConfirm.visibility = View.VISIBLE
            binding.signupBtnNextPink.visibility = View.INVISIBLE
            binding.signupBtnConfirm.visibility = View.VISIBLE
        }

        binding.signupBtnConfirmPink.setOnClickListener{


            val email = binding.signupEdtId.text.toString()
            val password = binding.signupEdtPwConfirm2.text.toString()
            val editor = ApplicationClass.sSharedPreferences.edit()
            editor.putString("email", email)
            editor.putString("password", password)
            editor.apply()
            Log.d("email", "vlaue:" +email)
            Log.d("password", "value:" +password)

            val confirmDialog = confirm_dialog(this)
            confirmDialog.show()



        }





    }

}