package com.example.risingtest.src.main.myPage

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.risingtest.R
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.risingtest.config.ApplicationClass.Companion.sSharedPreferences
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentLoginBinding
import com.example.risingtest.src.main.MainActivity
import com.example.risingtest.src.main.myPage.login.LogInActivityView
import com.example.risingtest.src.main.myPage.login.LogInResponse
import com.example.risingtest.src.main.myPage.login.LogInService
import com.example.risingtest.src.main.myPage.login.PostLogInRequest
import com.example.risingtest.src.main.myPage.signup.SignUpActivity


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::bind, R.layout.fragment_login),LogInActivityView {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtnTrue.setOnClickListener {

            val email = binding.loginEdtId.text.toString()
            val password = binding.loginEdtPw.text.toString()
            val postLogInRequest = PostLogInRequest(email = email, password = password)
            LogInService(this).tryPostLogIn(postLogInRequest)

        }

        binding.loginBtnSignup.setOnClickListener{
            val intent = Intent(requireActivity(), SignUpActivity::class.java)
            startActivity(intent)
        }


        binding.loginEdtPw.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if(binding.loginEdtPw.length() > 4 ) {
                    binding.loginBtnFalse.visibility = View.INVISIBLE
                    binding.loginBtnTrue.visibility = View.VISIBLE
                    binding.loginBtnTrue.isClickable = true
                } else {
                    binding.loginBtnFalse.visibility = View.VISIBLE
                    binding.loginBtnTrue.visibility = View.INVISIBLE

                }

            }
        })
    }

    override fun onPostLogInSuccess(response: LogInResponse) {



        if(response.code == 1000){
            val editor = ApplicationClass.sSharedPreferences.edit()
            editor.putString(ApplicationClass.X_ACCESS_TOKEN, response.result.jwt)
            editor.putInt("userId", response.result.userId)
            editor.apply()
            Log.d("jwt", "jwt:" + ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, response.result.jwt))


            val intent = Intent(requireActivity(), MainActivity::class.java)
            intent.putExtra("fragmentPosition",4)
            startActivity(intent)

        }

        if(response.code == 3003){
            binding.loginEdtPw.error = "이메일(ID 또는 이메일)과 비밀번호를 확인 후 다시 로그인해주세요.(5회이상 오류시 로그인 차단)"
        }

        if(response.code == 3004){
            binding.loginEdtPw.error = "이메일(ID 또는 이메일)과 비밀번호를 확인 후 다시 로그인해주세요.(5회이상 오류시 로그인 차단)"
        }


    }

    override fun onPostLogInFailure(message: String) {

    }

}