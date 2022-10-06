package com.example.risingtest.src.main.search.hotelroom

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface GetHotelRoomRetrofitInterface {
    @GET("/app/room")
    fun GetHotel(
        @Query("hotelid") hotelid: Int,
        @Query("startTime") startTime: String?,
        @Query("endTime") endTime: String?
    ) : Call<HotelRoomResponse>



}