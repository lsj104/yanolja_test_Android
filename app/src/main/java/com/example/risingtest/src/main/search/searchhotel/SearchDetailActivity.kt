package com.example.risingtest.src.main.search.searchhotel


import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.Transliterator
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySearchDetailBinding
import com.example.risingtest.src.main.search.hotelroom.*
import com.example.risingtest.src.main.search.searchhotel.model.ImageUrl
import com.example.risingtest.src.main.search.searchhotel.model.SearchDetailResponse
import com.example.risingtest.src.main.search.searchhotel.service.*

class SearchDetailActivity : BaseActivity<ActivitySearchDetailBinding>(ActivitySearchDetailBinding::inflate), SearchDetailActivityView, HotelRoomActivityView, ServiceView {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val id = intent.getIntExtra("id", 0)
        SearchDetailService(this).tryDetailSearch(id)
        ServiceService(this).tryGetService(id)

        val hotelid = 1
        val startTime = "2021-08-16"
        val endTime = "2021-08-18"
        HotelRoomService(this).tryGetRoom(hotelid = hotelid, startTime = startTime, endTime = endTime )


        binding.seller.setOnClickListener {
           val  intent = Intent(this, SellerActivity::class.java)
            startActivity(intent)
        }

        binding.recommendScroll.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY != 0) {
                binding.productInfoWhiteAppBarLayout.visibility = View.INVISIBLE
                binding.productInfoBlackAppBarLayout.visibility = View.VISIBLE
            } else {
                binding.productInfoWhiteAppBarLayout.visibility = View.VISIBLE
                binding.productInfoBlackAppBarLayout.visibility = View.INVISIBLE
            }
            if (scrollY > 0 && scrollY <= 100f) {
                val alpha = scrollY / 100f
                val resultColor = ColorUtils.blendARGB(
                    ContextCompat.getColor(applicationContext, R.color.white),
                    ContextCompat.getColor(applicationContext, R.color.white), alpha
                )
                binding.productInfoBlackAppBarLayout.setBackgroundColor(resultColor)

            } else if (scrollY < 10 && oldScrollY > scrollY) {
                binding.productInfoBlackAppBarLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.white
                    )
                )
            } else if (scrollY > 150f) {
                binding.productInfoBlackAppBarLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.white
                    )
                )
                binding.productInfoBlackAppBarLayout.translationZ = 5f
            }
        }


    }

    override fun onSearchDetailSuccess(response: SearchDetailResponse) {
        if (response.code == 1000){

            Log.d("onSearchDetailSuccess","1234")
            val result = response.result
            var MaimList: List<ImageUrl> = result.imageUrl
            binding.searchDetailHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
            val adapter = SearchDetailHorizontalAdapter()
            adapter.listData.addAll(MaimList)
            binding.searchDetailHorizontal.adapter = adapter
            binding.textLevel.text = result.level
            binding.textName.text = result.name
            binding.textReviewScore.text = result.reviewScore
            binding.textReviewCount.text = result.reviewCount.toString()
            binding.textSubwayText.text = result.subwayText
            binding.textAboutHotel.text = result.aboutHotel


        }
    }

    override fun onSearchDetailFailure(message: String) {
        showCustomToast("오류 : $message")
    }

    override fun onHotelRoonSuccess(response: HotelRoomResponse) {
        if (response.code == 1000){
            val result = response.result
            var HotelRoomList: List<HotelResult> = result
            binding.hotelRoomRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
            var adapter = HotelRoomAdapter()
            adapter.listData.addAll(HotelRoomList)
            binding.hotelRoomRecyclerView.adapter = adapter
        }
    }

    override fun onHotelRoomFailure(message: String) {
        showCustomToast("오류 : $message")
    }

    override fun onServiceSuccess(response: ServiceResponse) {
        Log.d("ServieSuccess", "12345")
        if(response.code == 1000){
            val result = response.result
            var Service: List<ServiceResult> = result
            binding.searchServiceRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
            var adapter = ServiceAdapter()
            adapter.listData.addAll(Service)
            binding.searchServiceRecyclerView.adapter = adapter
        }
    }

    override fun onServiceFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("SeviceFailure", "12345")
    }
}