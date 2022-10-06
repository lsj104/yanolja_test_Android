package com.example.risingtest.src.main.search.bookthird

import com.google.gson.annotations.SerializedName

data class UserInfo (
        @SerializedName("phoneNumber") val phoneNumber: String?,
        @SerializedName("remainPoint") val remainPoint: Int,
        @SerializedName("couponlist") val couponlist: List<CouponList>

        )