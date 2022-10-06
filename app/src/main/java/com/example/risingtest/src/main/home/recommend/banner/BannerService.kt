package com.example.risingtest.src.main.home.recommend.banner

import com.example.risingtest.config.ApplicationClass
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class BannerService(val view: BannerView) {
    fun tryGetBanner(){
        val BannerRetrofitInterface = ApplicationClass.sRetrofit.create(BannerRetrofitInterface::class.java)
        BannerRetrofitInterface.Banner().enqueue(object :Callback<BennerResponse>{
            override fun onResponse(call: Call<BennerResponse>, response: Response<BennerResponse>) {
                view.onBannerSuccess(response.body() as BennerResponse)
            }

            override fun onFailure(call: Call<BennerResponse>, t: Throwable) {
                view.onBannerFailure(t.message ?: "통신 오류")
            }

        })
    }
}