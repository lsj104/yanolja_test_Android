package com.example.risingtest.src.main.search.hotelroom.seller

import com.google.gson.annotations.SerializedName

data class SellerResult(
    @SerializedName("callingNumber") val callingNumber: String,
    @SerializedName("chiefName") val chiefName: String,
    @SerializedName("email") val email: String,
    @SerializedName("hotelName") val hotelName: String,
    @SerializedName("id") val id: Int,
    @SerializedName("locatedAt") val locatedAt: String,
    @SerializedName("regNum") val regNum: String
)