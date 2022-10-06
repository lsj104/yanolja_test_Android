package com.example.risingtest.src.main.myPage.signup

interface SignUpSecondActivityView {
    fun onPostSignUpSecondSuccess(response: SignUpSecondResponse)
    fun onPostSignUpSecondFailure(message: String)
}