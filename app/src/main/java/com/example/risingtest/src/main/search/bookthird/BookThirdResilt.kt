package com.example.risingtest.src.main.search.bookthird

import com.google.gson.annotations.SerializedName

data class BookThirdResilt(
    @SerializedName("roomInfo") val roomInfo: RoomInfo,
    @SerializedName("userInfo") val userInfo: UserInfo

)
