package com.example.risingtest.src.main.myPage.signup

import com.google.gson.annotations.SerializedName

data class PostSignUpSecondRequst(
        @SerializedName("email") val email: String?,
        @SerializedName("password") val password: String?,
        @SerializedName("phoneNumber") val phoneNumber: String)
