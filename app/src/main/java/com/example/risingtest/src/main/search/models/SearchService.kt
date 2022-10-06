package com.example.risingtest.src.main.search.models

import android.util.Log
import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchService(val view: SearchActivityView)  {

    fun trySearch(startTime: String?, endTime: String?, adult: Int, child: Int, categoryid: String?, keyword: String?){
        Log.d("trySearch","1234")
        val GetSearchRetrofitInterface = ApplicationClass.sRetrofit.create(GetSearchRetrofitInterface::class.java)
        Log.d("GetSearchRetrofitInterface","1234")
        GetSearchRetrofitInterface.Search(startTime, endTime, adult, child, categoryid, keyword).enqueue(object :Callback<SearchResponse>{
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                Log.d("onResponse","1234")
                view.onSearchSuccess(response.body() as SearchResponse)
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                view.onSearchFailure(t.message ?: "통신 오류")
                Log.d("onFailure","1234")

            }

        })
    }


}