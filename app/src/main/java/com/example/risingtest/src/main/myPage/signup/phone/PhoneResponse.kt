package com.example.risingtest.src.main.myPage.signup.phone
import com.google.gson.annotations.SerializedName

data class PhoneResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean = false,
    @SerializedName("code") val code: Int = 0,
    @SerializedName("message") val message: String? = null,
    @SerializedName("result") val result: PhoneResult
        )