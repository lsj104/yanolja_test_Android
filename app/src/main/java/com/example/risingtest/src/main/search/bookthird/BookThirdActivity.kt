package com.example.risingtest.src.main.search.bookthird

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.risingtest.R
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityBookThirdBinding
import com.example.risingtest.src.main.MainActivity
import java.text.DecimalFormat

class BookThirdActivity : BaseActivity<ActivityBookThirdBinding>(ActivityBookThirdBinding::inflate), BookThirdActivityView{

    var formatter = DecimalFormat("###,###")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val jwt =  ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, "")
        val userId = ApplicationClass.sSharedPreferences.getInt("userId",0)
        val startTime = "2021-08-16"
        val endTime = "2021-08-18"
        val roomid = 1

        BookThirdService(this).tryGetBookThird(jwt = jwt, userid = userId, startTime = startTime, endTime = endTime, roomid = roomid)


        binding.bookThirdBtnComplete.setOnClickListener {

            showCustomToast("예약이 완료되었습니다.")
            val intent = Intent(this, MainActivity:: class.java)
            intent.putExtra("fragmentPosition",4)
            startActivity(intent)

        }

    }

    override fun onBookThirdSeccess(response: BookThirdResponse) {

        if (response.code == 1000){
            val result = response.result
            binding.bookThirdHotelName.text = result.roomInfo.hotelName
            binding.bookThirdRoomName.text = result.roomInfo.roomName
            binding.bookThirdCheckinInfo.text = result.roomInfo.checkinInfo
            val phoneNumber = result.userInfo.phoneNumber
            binding.bookThirdEdtPhone.setText(phoneNumber)
            binding.bookThirdPhoneNumber.setText(phoneNumber)
            binding.bookThirdPrice.text = formatter.format(result.roomInfo.price)
            binding.bookThirdPrice3.text = formatter.format(result.roomInfo.price)
            binding.bookThirdPrice2.text = formatter.format(result.roomInfo.price)
            binding.bookThirdBtnComplete.text = "${formatter.format(result.roomInfo.price)}원 결제하기"
            Log.d("BookThird", "BookThirdSeccess")
        }
    }

    override fun onBookThirdFailure(message: String) {
        showCustomToast("오류 : $message")

        Log.d("BookThird", "onBookThirdFailure")
    }
}