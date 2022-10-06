package com.example.risingtest.src.main.search.reservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityReservationBinding
import com.example.risingtest.src.main.search.book.BookActivityView
import com.example.risingtest.src.main.search.book.BookResponse
import com.example.risingtest.src.main.search.book.BookService
import com.example.risingtest.src.main.search.bookthird.BookThirdActivityView
import com.example.risingtest.src.main.search.bookthird.BookThirdResponse
import com.example.risingtest.src.main.search.bookthird.BookThirdService

class ReservationActivity :BaseActivity<ActivityReservationBinding>(ActivityReservationBinding::inflate), BookThirdActivityView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val jwt =  ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, "")
        val userId = ApplicationClass.sSharedPreferences.getInt("userId",0)
        val startTime = "2021-08-16"
        val endTime = "2021-08-18"
        val roomid = 1

        BookThirdService(this).tryGetBookThird(jwt = jwt, userid = userId, startTime = startTime, endTime = endTime, roomid = roomid)
    }

    override fun onBookThirdSeccess(response: BookThirdResponse) {
        if (response.code == 1000) {
            val result = response.result
            binding.reservationName.text =  result.roomInfo.hotelName
            binding.reservationRoom.text = result.roomInfo.roomName

        }
    }

    override fun onBookThirdFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}