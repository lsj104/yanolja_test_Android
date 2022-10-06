package com.example.risingtest.src.main.search.searchhotel.model
import com.google.gson.annotations.SerializedName

data class SearchDetailResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: Result
)