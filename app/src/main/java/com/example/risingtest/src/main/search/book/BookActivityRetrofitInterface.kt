package com.example.risingtest.src.main.search.book

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Call

interface BookActivityRetrofitInterface {
    @GET("/app/room/{id}")
    fun GetRoom(
        @Path("id") id: Int,
        @Query("startTime") startTime: String?,
        @Query("endTime") endTime: String?
    ): Call<BookResponse>
}