package com.example.risingtest.src.main.myPage.login

interface LogInActivityView {
    fun onPostLogInSuccess(response: LogInResponse)
    fun onPostLogInFailure(message: String)
}