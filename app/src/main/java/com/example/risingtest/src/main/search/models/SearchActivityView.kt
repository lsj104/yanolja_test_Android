package com.example.risingtest.src.main.search.models

interface SearchActivityView {

    fun onSearchSuccess(response: SearchResponse)
    fun onSearchFailure(message: String)
}