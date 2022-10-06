package com.example.risingtest.src.main.search.hotelroom

interface HotelRoomActivityView {

    fun onHotelRoonSuccess(response: HotelRoomResponse)
    fun onHotelRoomFailure(message: String)
}