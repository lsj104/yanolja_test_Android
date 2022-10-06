package com.example.risingtest.src.main.home.domestic.models

import com.google.gson.annotations.SerializedName
import kotlin.Result

data class DomesticResponse (
        @SerializedName("isSuccess") val isSuccess: Boolean = false,
        @SerializedName("code") val code: Int = 0,
        @SerializedName("message") val message: String? = null,
        @SerializedName("result") val result: DomesticResult
)