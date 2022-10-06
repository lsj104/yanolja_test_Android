package com.example.risingtest.src.main.search.bookthird



interface BookThirdActivityView {
    fun onBookThirdSeccess(response: BookThirdResponse)
    fun onBookThirdFailure(message:String)
}