package com.example.risingtest.src.main.search.hotelroom.seller

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface GetSellerRetorfitInterface {
    @GET("/app/hotel/sellerinfo/{id}")
    fun GetSeller(
        @Path("id") id: Int
    ) : Call<SellerResponse>
}