package com.example.risingtest.src.main.search.book

import com.google.gson.annotations.SerializedName

data class BookImgUrl(
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("photoId") val photoId: Int,
)
