package com.example.risingtest.src.main.search.models

import com.google.gson.annotations.SerializedName


data class SearchResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean ,
    @SerializedName("code") val code: Int ,
    @SerializedName("message") val message: String? ,
    @SerializedName("result") val result: List<Result>
)