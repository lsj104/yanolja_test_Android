package com.example.risingtest.src.main.myPage.login

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LogInRetrofitInterface {
    @POST("/app/login")
    fun postLogin(@Body params: PostLogInRequest): Call<LogInResponse>
}