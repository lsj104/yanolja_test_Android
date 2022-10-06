package com.example.risingtest.src.main.search.bookthird

import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookThirdService(val view: BookThirdActivityView) {
    fun tryGetBookThird(jwt: String? , userid:Int, roomid:Int, startTime:String, endTime: String){
        val BookThirdRetrofitInterface = ApplicationClass.sRetrofit.create(BookThirdRetrofitInterface::class.java)

        BookThirdRetrofitInterface.GetBookThird(jwt, userid, roomid, startTime, endTime).enqueue(object : Callback<BookThirdResponse>{
            override fun onResponse(call: Call<BookThirdResponse>, response: Response<BookThirdResponse>) {
                view.onBookThirdSeccess(response.body() as BookThirdResponse)
            }

            override fun onFailure(call: Call<BookThirdResponse>, t: Throwable) {
                view.onBookThirdFailure(t.message ?: "통신 오류")
            }

        })
    }
}