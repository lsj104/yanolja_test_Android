package com.example.risingtest.src.main.myPage.signup

import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpSecondService(val view: SignUpSecondActivityView) {
    fun tryPostSignUpSecond(postSignUpSecondRequst: PostSignUpSecondRequst){
        val SignUpSecondRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpSecondRetrofitInterface::class.java)
        SignUpSecondRetrofitInterface.postSignUpSecond(postSignUpSecondRequst).enqueue(object : Callback<SignUpSecondResponse>{
            override fun onResponse(call: Call<SignUpSecondResponse>, response: Response<SignUpSecondResponse>) {
                view.onPostSignUpSecondSuccess(response.body() as  SignUpSecondResponse)
            }

            override fun onFailure(call: Call<SignUpSecondResponse>, t: Throwable) {
                view.onPostSignUpSecondFailure(t.message ?: "통신 오류")
            }


        })
    }
}