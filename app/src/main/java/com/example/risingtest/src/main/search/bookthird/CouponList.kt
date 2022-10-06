package com.example.risingtest.src.main.search.bookthird

import com.google.gson.annotations.SerializedName

data class CouponList(
    @SerializedName("couponId") val couponId: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("salePrice") val salePrice:Int
)
