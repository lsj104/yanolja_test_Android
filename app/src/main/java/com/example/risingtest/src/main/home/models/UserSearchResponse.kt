package com.example.risingtest.src.main.home.models

import com.google.gson.annotations.SerializedName

data class UserSearchResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<ResultUserSearch>

    )