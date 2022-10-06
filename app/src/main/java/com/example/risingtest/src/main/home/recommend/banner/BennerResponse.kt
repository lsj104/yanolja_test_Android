package com.example.risingtest.src.main.home.recommend.banner

import com.google.gson.annotations.SerializedName

data class BennerResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean = false,
    @SerializedName("code") val code: Int = 0,
    @SerializedName("message") val message: String? = null,
    @SerializedName("result") val result:  List<BannerResult>
        )