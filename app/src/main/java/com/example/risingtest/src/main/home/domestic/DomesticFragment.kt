package com.example.risingtest.src.main.home.domestic

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentDomesticBinding
import com.example.risingtest.src.main.home.domestic.models.DomesticResponse
import com.example.risingtest.src.main.home.domestic.models.DomesticView
import com.example.risingtest.src.main.home.recommend.RecommendViewPagerAdapter


class DomesticFragment : BaseFragment<FragmentDomesticBinding>(FragmentDomesticBinding::bind, R.layout.fragment_domestic),DomesticView {
    private var numBanner = 6
    private var currentPosition = Int.MAX_VALUE / 3
    private var myHandler = MyHandler()
    private val intervalTime = 1500.toLong()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recommendViewPager.adapter = RecommendViewPagerAdapter(getImgList())
        binding.recommendViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.recommendViewPager.setCurrentItem(currentPosition, false)


        binding.recommendViewPager.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.recommendTextviewCurrent.text = "0${(position%6)+1}"
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when(state){
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })

        }


    }

    private fun getImgList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5, R.drawable.banner6)
    }

    private fun autoScrollStart(intervalTime: Long) {
        myHandler.removeMessages(0)
        myHandler.sendEmptyMessageDelayed(0, intervalTime)
    }
    private fun autoScrollStop(){
        myHandler.removeMessages(0)
    }

    private inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what == 0) {
                binding.recommendViewPager.setCurrentItem(++currentPosition, true)
                autoScrollStart(intervalTime)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }


    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }

    private fun getBannerList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
    }

    override fun onDomesticSuccess(response: DomesticResponse) {
        TODO("Not yet implemented")
    }

    override fun onDomesticFailure(message: String) {
        TODO("Not yet implemented")
    }
}