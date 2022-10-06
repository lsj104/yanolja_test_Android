package com.example.risingtest.src.main.search.hotelroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySellerBinding
import com.example.risingtest.src.main.search.hotelroom.seller.SellerActivityView
import com.example.risingtest.src.main.search.hotelroom.seller.SellerResponse
import com.example.risingtest.src.main.search.hotelroom.seller.SellerService

class SellerActivity : BaseActivity<ActivitySellerBinding>(ActivitySellerBinding :: inflate), SellerActivityView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = 1
        SellerService(this).tryGetSeller(id = id)
    }

    override fun onSellerSuccess(response: SellerResponse) {
        if (response.code == 1000){
            binding.sellerName1.text = response.result.chiefName
            binding.sellerProductName1.text = response.result.hotelName
            binding.sellerAdress1.text = response.result.locatedAt
            binding.sellerEmail1.text = response.result.email
            binding.cellerPhone1.text = response.result.callingNumber
            binding.sellerId1.text = response.result.regNum
        }
    }

    override fun onSellerFailure(message: String) {
        showCustomToast("오류 : $message")
    }
}