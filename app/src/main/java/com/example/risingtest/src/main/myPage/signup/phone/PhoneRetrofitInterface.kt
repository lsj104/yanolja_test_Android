package com.example.risingtest.src.main.myPage.signup.phone

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PhoneRetrofitInterface {
    @POST("/app/phone-validation")
    fun postPhone(@Body params: PostPhoneRequest): Call<PhoneResponse>
}