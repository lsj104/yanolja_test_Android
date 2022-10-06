package com.example.risingtest.src.main.search.book

import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookService(val view: BookActivityView) {

    fun tryGetBook(id:Int, startTime:String, endTime:String){
        val BookActivityRetrofitInterface = ApplicationClass.sRetrofit.create(BookActivityRetrofitInterface::class.java)

        BookActivityRetrofitInterface.GetRoom(id, startTime, endTime).enqueue(object :Callback<BookResponse>{
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                view.onBookSuccess(response.body() as BookResponse)
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                view.onBookFailure(t.message ?: "통신 오류")
            }

        })
    }
}