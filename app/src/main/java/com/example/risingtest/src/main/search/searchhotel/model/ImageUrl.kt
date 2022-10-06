package com.example.risingtest.src.main.search.searchhotel.model

import com.google.gson.annotations.SerializedName

data class ImageUrl(
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("photoId") val photoId: Int,
    @SerializedName("text") val text: String
)