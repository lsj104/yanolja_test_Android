package com.example.risingtest.src.main.search.hotelroom

import com.google.gson.annotations.SerializedName

data class HotelResult (
    @SerializedName("id") val id: Int,
    @SerializedName("imageUrl")val imageUrl: String,
    @SerializedName("inclusion")val inclusion: String,
    @SerializedName("kindText")val kindText: String,
    @SerializedName("name")val name: String,
    @SerializedName("personnel")val personnel: String,
    @SerializedName("priceafterSale")val priceafterSale: Int,
    @SerializedName("pricebeforeSale")val pricebeforeSale: Int,
    @SerializedName("saleRate")val saleRate: String
        )