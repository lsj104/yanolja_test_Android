package com.example.risingtest.src.main.search.hotelroom

import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HotelRoomService(val view: HotelRoomActivityView) {

    fun tryGetRoom(startTime: String?, endTime: String?, hotelid:Int){
        val GetHotelRoomRetrofitInterface = ApplicationClass.sRetrofit.create(GetHotelRoomRetrofitInterface::class.java)

        GetHotelRoomRetrofitInterface.GetHotel(hotelid, startTime, endTime).enqueue(object:Callback<HotelRoomResponse> {
            override fun onResponse(call: Call<HotelRoomResponse>, response: Response<HotelRoomResponse>) {
                view.onHotelRoonSuccess(response.body() as HotelRoomResponse)
            }

            override fun onFailure(call: Call<HotelRoomResponse>, t: Throwable) {
                view.onHotelRoomFailure(t.message ?: "통신 오류")
            }

        } )
    }
}