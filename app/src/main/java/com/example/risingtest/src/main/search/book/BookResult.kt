package com.example.risingtest.src.main.search.book

import com.google.gson.annotations.SerializedName

data class BookResult(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("inclusion") val inclusion: String?,
    @SerializedName("personnel") val personnel: String?,
    @SerializedName("hotelName") val hotelName: String?,
    @SerializedName("text") val text: String?,
    @SerializedName("pricebeforeSale") val pricebeforeSale: Int,
    @SerializedName("saleRate") val saleRate: String?,
    @SerializedName("priceafterSale") val priceafterSale: Int,
    @SerializedName("info") val info: String?,
    @SerializedName("reservationInfo") val reservationInfo: String?,
    @SerializedName("cancelInfo") val cancelInfo: String?,
    @SerializedName("imageUrl") val imageUrl: List<BookImgUrl>
)
