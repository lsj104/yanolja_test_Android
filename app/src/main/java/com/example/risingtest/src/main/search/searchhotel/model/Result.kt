package com.example.risingtest.src.main.search.searchhotel.model

import com.example.risingtest.src.main.search.book.BookImgUrl
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("aboutHotel") val aboutHotel: String,
    @SerializedName("callingNumber") val callingNumber: String,
    @SerializedName("facility") val facility: Any,
    @SerializedName("id") val id: Int,
    @SerializedName("imageUrl") val imageUrl: List<ImageUrl>,
    @SerializedName("level") val level: String,
    @SerializedName("locatedAt") val locatedAt: String,
    @SerializedName("name") val name: String,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("reviewScore") val reviewScore: String,
    @SerializedName("subwayText") val subwayText: String

)