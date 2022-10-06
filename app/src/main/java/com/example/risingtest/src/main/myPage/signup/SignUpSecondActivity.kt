package com.example.risingtest.src.main.myPage.signup


import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySignUpSecondBinding
import com.example.risingtest.src.main.MainActivity
import com.example.risingtest.src.main.myPage.signup.phone.*

class SignUpSecondActivity : BaseActivity<ActivitySignUpSecondBinding>(ActivitySignUpSecondBinding::inflate),SignUpSecondActivityView, PhoneActivityView {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val validationCode = ApplicationClass.sSharedPreferences.getString("validationCode","")

        binding.signupBtnNextTrue.setOnClickListener{
            binding.signupBtnNextTrue.visibility = View.INVISIBLE
            binding.signupBtnNextCount.visibility = View.VISIBLE
            binding.signupSecondTextLayout.visibility = View.VISIBLE
            binding.singupSecondBottom.visibility = View.VISIBLE

            val phonenumber = binding.signupEdtPhone.text.toString()
            val postPhoneRequest = PostPhoneRequest(phoneNumber =phonenumber )
            PhoneService(this).tryPhone(postPhoneRequest)
            Log.d("postPhonenumber", "value:" + postPhoneRequest )

        }

        binding.signupBtnCompletePink.setOnClickListener {

            if (!(validationCode.equals(binding.signupEdtMsg.toString()))){
                val email = ApplicationClass.sSharedPreferences.getString("email", "")
                val password = ApplicationClass.sSharedPreferences.getString("password","")
                val phonenumber = binding.signupEdtPhone.text.toString()
                Log.d("email", "vlaue:" +email)
                Log.d("password", "value:" +password)
                val postRequest = PostSignUpSecondRequst( phoneNumber = phonenumber,password = password, email = email)
                SignUpSecondService(this).tryPostSignUpSecond(postRequest)
            }

            }




        binding.signupEdtPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        binding.signupEdtPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(binding.signupEdtPhone.length() > 9){
                    binding.signupBtnNextFalse.visibility = View.INVISIBLE
                    binding.signupBtnNextTrue.visibility = View.VISIBLE
                    binding.signupBtnNextTrue.isClickable = true
                }


            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        binding.signupEdtMsg.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(binding.signupEdtMsg.length()>5){
                    binding.signupBtnComplete.visibility = View.INVISIBLE
                    binding.signupBtnCompletePink.visibility = View.VISIBLE
                    binding.signupBtnCompletePink.isClickable = true
                }

            }

            override fun afterTextChanged(s: Editable?) {



            }

        })
    }

    override fun onPostSignUpSecondSuccess(response: SignUpSecondResponse) {
        if (response.code == 1000){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onPostSignUpSecondFailure(message: String) {
        showCustomToast("오류 : $message")
    }

    override fun onPostPhoneSuccess(response: PhoneResponse) {
        if(response.code == 1000){
            val editor1 = ApplicationClass.sSharedPreferences.edit()
            editor1.putString("validationCode", response.result.validationCode)
            editor1.apply()
        }
    }

    override fun onPostPhoneFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}