package com.example.risingtest.src.main.home.recommend.banner

interface BannerView {

    fun onBannerSuccess(response: BennerResponse)
    fun onBannerFailure(message: String)

}