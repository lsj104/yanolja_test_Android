package com.example.risingtest.src.main.search.bookthird

import com.google.gson.annotations.SerializedName

data class RoomInfo(
    @SerializedName("hotelName") val hotelName: String?,
    @SerializedName("roomName") val roomName: String?,
    @SerializedName("dateInfo") val dateInfo: String?,
    @SerializedName("checkinInfo") val checkinInfo: String?,
    @SerializedName("price") val price: Int?
)
