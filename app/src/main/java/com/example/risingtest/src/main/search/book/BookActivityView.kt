package com.example.risingtest.src.main.search.book


interface BookActivityView {

    fun onBookSuccess(response: BookResponse)
    fun onBookFailure(message:String)

}