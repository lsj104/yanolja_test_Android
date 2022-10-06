package com.example.risingtest.src.main.myPage.signup.phone

interface PhoneActivityView {
    fun onPostPhoneSuccess(response: PhoneResponse)
    fun onPostPhoneFailure(message: String)
}