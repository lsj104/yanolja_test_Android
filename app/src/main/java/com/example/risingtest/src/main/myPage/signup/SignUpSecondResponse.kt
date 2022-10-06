package com.example.risingtest.src.main.myPage.signup

import com.google.gson.annotations.SerializedName

data class SignUpSecondResponse (
        @SerializedName("isSuccess") val isSuccess: Boolean = false,
        @SerializedName("code") val code: Int = 0,
        @SerializedName("message") val message: String? = null
)