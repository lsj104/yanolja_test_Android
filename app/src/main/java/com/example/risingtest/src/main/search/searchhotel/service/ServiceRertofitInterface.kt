package com.example.risingtest.src.main.search.searchhotel.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface ServiceRertofitInterface {
    @GET("/app/hotel/facility/{id}")
    fun GetService(
            @Path("id") id: Int
    ): Call<ServiceResponse>
}