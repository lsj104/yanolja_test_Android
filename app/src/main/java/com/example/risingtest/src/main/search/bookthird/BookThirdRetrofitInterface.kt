package com.example.risingtest.src.main.search.bookthird

import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BookThirdRetrofitInterface {
    @GET("/app/reservation")
    fun GetBookThird(
        @Header("jwt") jwt: String?,
        @Query("userid") userid: Int,
        @Query("roomid") roomid: Int,
        @Query("startTime") startTime: String?,
        @Query("endTime") endTime: String?

    ): Call<BookThirdResponse>
}