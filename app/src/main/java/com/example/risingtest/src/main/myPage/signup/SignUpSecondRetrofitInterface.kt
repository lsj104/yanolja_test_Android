package com.example.risingtest.src.main.myPage.signup

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface SignUpSecondRetrofitInterface {
    @POST("/app/user")
    fun postSignUpSecond(@Body params: PostSignUpSecondRequst): Call<SignUpSecondResponse>
}