package com.example.risingtest.src.main.search.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetSearchRetrofitInterface {

    @GET("/app/hotel-search-keyword")
    fun Search(
        @Query("startTime") startTime:String?,
        @Query("endTime") endTime:String?,
        @Query("adult") adult:Int,
        @Query("child") child:Int,
        @Query("categoryid") categoryid:String?,
        @Query("keyword") keyword:String?
    ) : Call<SearchResponse>
}