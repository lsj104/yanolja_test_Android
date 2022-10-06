package com.example.risingtest.src.main.search.book
import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: BookResult
)
