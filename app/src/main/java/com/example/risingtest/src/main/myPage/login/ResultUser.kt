package com.example.risingtest.src.main.myPage.login

import com.google.gson.annotations.SerializedName

data class ResultUser(@SerializedName("userId") val userId: Int,
                      @SerializedName("jwt") val jwt: String)
