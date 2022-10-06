package com.example.risingtest.src.main.home.domestic.models

import retrofit2.Call
import retrofit2.http.GET

interface DomesticRetrofitInterface {

    @GET("/app/hotel/1")
    fun Domestic() : Call<DomesticResponse>
}