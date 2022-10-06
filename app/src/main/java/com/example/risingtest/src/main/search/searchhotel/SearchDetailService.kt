package com.example.risingtest.src.main.search.searchhotel

import android.util.Log
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.search.searchhotel.model.SearchDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchDetailService(val view: SearchDetailActivityView) {

    fun tryDetailSearch(id: Int){
        val GetSearchDetailRetrofitInterface = ApplicationClass.sRetrofit.create(GetSearchDetailRetrofitInterface::class.java)
        GetSearchDetailRetrofitInterface.SearchDetail(id).enqueue(object :Callback<SearchDetailResponse>{
            override fun onResponse(call: Call<SearchDetailResponse>, response: Response<SearchDetailResponse>) {
                Log.d("onResponse", "1234")
                view.onSearchDetailSuccess(response.body() as SearchDetailResponse)
            }

            override fun onFailure(call: Call<SearchDetailResponse>, t: Throwable) {
                Log.d("onFailure", "1234")
                view.onSearchDetailFailure(t.message ?: "통신 오류")
            }

        })
    }
}