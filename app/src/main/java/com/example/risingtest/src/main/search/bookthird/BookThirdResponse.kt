package com.example.risingtest.src.main.search.bookthird

import com.google.gson.annotations.SerializedName

data class BookThirdResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: BookThirdResilt
    )