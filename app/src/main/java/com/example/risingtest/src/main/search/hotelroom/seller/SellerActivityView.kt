package com.example.risingtest.src.main.search.hotelroom.seller

interface SellerActivityView {

    fun onSellerSuccess(response: SellerResponse)
    fun onSellerFailure(message:String)

}