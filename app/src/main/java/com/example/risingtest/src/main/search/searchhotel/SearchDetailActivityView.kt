package com.example.risingtest.src.main.search.searchhotel

import com.example.risingtest.src.main.search.searchhotel.model.SearchDetailResponse

interface SearchDetailActivityView {

    fun onSearchDetailSuccess(response: SearchDetailResponse)
    fun onSearchDetailFailure(message: String)
}