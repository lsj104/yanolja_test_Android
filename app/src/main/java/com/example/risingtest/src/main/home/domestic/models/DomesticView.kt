package com.example.risingtest.src.main.home.domestic.models

interface DomesticView {

    fun onDomesticSuccess(response: DomesticResponse)
    fun onDomesticFailure(message: String)
}