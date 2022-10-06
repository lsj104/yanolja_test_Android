package com.example.risingtest.src.main.search.searchhotel.service

import com.google.gson.annotations.SerializedName

data class ServiceResponse (
        @SerializedName("isSuccess") val isSuccess: Boolean,
        @SerializedName("code") val code: Int,
        @SerializedName("message") val message: String?,
        @SerializedName("result") val result: List<ServiceResult>
        )
