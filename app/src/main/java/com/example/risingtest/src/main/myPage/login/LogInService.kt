package com.example.risingtest.src.main.myPage.login

import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInService(val view:LogInActivityView) {
    fun tryPostLogIn(postLogInRequest: PostLogInRequest){
        val LogInRetrofitInterface = ApplicationClass.sRetrofit.create(LogInRetrofitInterface::class.java)
        LogInRetrofitInterface.postLogin(postLogInRequest).enqueue(object : Callback<LogInResponse>{
            override fun onResponse(call: Call<LogInResponse>, response: Response<LogInResponse>) {
                view.onPostLogInSuccess(response.body() as LogInResponse)
            }

            override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                view.onPostLogInFailure(t.message ?: "통신 오류")
            }

        })
    }

}