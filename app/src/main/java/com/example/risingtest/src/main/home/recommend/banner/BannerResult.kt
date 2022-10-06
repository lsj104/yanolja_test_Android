package com.example.risingtest.src.main.home.recommend.banner

import com.google.gson.annotations.SerializedName

data class BannerResult (
    @SerializedName("id")  val id: Int,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("text")  val text: String
        )