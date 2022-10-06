package com.example.risingtest.src.main.search.hotelroom

import com.google.gson.annotations.SerializedName

data class HotelRoomResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: List<HotelResult>
        )