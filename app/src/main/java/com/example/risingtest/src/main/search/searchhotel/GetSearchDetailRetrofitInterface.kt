package com.example.risingtest.src.main.search.searchhotel

import com.example.risingtest.src.main.search.searchhotel.model.SearchDetailResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface GetSearchDetailRetrofitInterface {
    @GET("/app/hotel/{id}")
    fun SearchDetail(
        @Path("id") id: Int
    ) : Call<SearchDetailResponse>
}