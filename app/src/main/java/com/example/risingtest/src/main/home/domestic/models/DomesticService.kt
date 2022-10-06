package com.example.risingtest.src.main.home.domestic.models

import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class DomesticService(val view: DomesticView) {

    fun tryDomestic(){

        val DomesticRetrofitInterface = ApplicationClass.sRetrofit.create(DomesticRetrofitInterface::class.java)

        DomesticRetrofitInterface.Domestic().enqueue(object : Callback<DomesticResponse>{
            override fun onResponse(call: Call<DomesticResponse>, response: Response<DomesticResponse>) {
                view.onDomesticSuccess(response.body() as DomesticResponse)
            }

            override fun onFailure(call: Call<DomesticResponse>, t: Throwable) {
                view.onDomesticFailure(t.message ?: "통신 오류")
            }

        })
    }
}