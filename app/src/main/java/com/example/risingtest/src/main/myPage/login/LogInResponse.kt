package com.example.risingtest.src.main.myPage.login

import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import java.util.*

data class LogInResponse (
        @SerializedName("isSuccess") val isSuccess: Boolean = false,
        @SerializedName("code") val code: Int = 0,
        @SerializedName("message") val message: String? = null,
        @SerializedName("result") val result: ResultUser

        )