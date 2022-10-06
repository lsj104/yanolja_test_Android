package com.example.risingtest.src.main.search.searchhotel.service

interface ServiceView {

    fun onServiceSuccess(response: ServiceResponse)
    fun onServiceFailure(message:String)
}