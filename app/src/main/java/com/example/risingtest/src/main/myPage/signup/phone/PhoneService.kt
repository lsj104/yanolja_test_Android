package com.example.risingtest.src.main.myPage.signup.phone

import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhoneService(val view: PhoneActivityView) {
    fun tryPhone(postPhoneRequest: PostPhoneRequest){
        val PhoneRetrofitInterface = ApplicationClass.sRetrofit.create(PhoneRetrofitInterface::class.java)
        PhoneRetrofitInterface.postPhone(postPhoneRequest).enqueue(object :Callback<PhoneResponse>
        {
            override fun onResponse(call: Call<PhoneResponse>, response: Response<PhoneResponse>) {
                view.onPostPhoneSuccess(response.body() as  PhoneResponse)
            }

            override fun onFailure(call: Call<PhoneResponse>, t: Throwable) {
                view.onPostPhoneFailure(t.message ?: "통신 오류")
            }

        })
    }
}