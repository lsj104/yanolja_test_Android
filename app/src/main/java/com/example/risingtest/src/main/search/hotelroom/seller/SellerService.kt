package com.example.risingtest.src.main.search.hotelroom.seller

import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellerService(val view: SellerActivityView) {

    fun tryGetSeller(id : Int){
        val GetSellerRetorfitInterface = ApplicationClass.sRetrofit.create(GetSellerRetorfitInterface::class.java)
        GetSellerRetorfitInterface.GetSeller(id).enqueue(object :Callback<SellerResponse>{
            override fun onResponse(call: Call<SellerResponse>, response: Response<SellerResponse>) {
              view.onSellerSuccess(response.body() as SellerResponse)
            }

            override fun onFailure(call: Call<SellerResponse>, t: Throwable) {
                view.onSellerFailure(t.message ?: "통신 오류")
            }

        })
    }
}