package com.example.risingtest.src.main.search.models

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("categoryName") val categoryName: String ,
    @SerializedName("id")val id: Int ,
    @SerializedName("imageUrl") val imageUrl: String ,
    @SerializedName("kindText")val kindText: String,
    @SerializedName("name")val name: String,
    @SerializedName("priceafterSale")val priceafterSale: Int ,
    @SerializedName("pricebeforeSale")val pricebeforeSale: Int ,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("reviewScore")val reviewScore: String,
    @SerializedName("saleRate")val saleRate: String,
    @SerializedName("subwayText")val subwayText: String
)