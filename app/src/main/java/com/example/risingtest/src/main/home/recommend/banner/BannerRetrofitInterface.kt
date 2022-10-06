package com.example.risingtest.src.main.home.recommend.banner

import retrofit2.http.GET
import retrofit2.Call

interface BannerRetrofitInterface {
    @GET("/app/advertise")
    fun Banner(): Call<BennerResponse>
}