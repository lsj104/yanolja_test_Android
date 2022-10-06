package com.example.risingtest.src.main.search.book

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityBookBinding
import com.example.risingtest.src.main.search.booksecond.BookSecondActivity
import java.text.DecimalFormat

class BookActivity : BaseActivity<ActivityBookBinding>(ActivityBookBinding::inflate),BookActivityView {

    var formatter = DecimalFormat("###,###")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = 1
        val startTime = "2021-08-16"
        val endTime = "2021-08-18"
        BookService(this).tryGetBook(id, startTime = startTime, endTime = endTime)


        binding.bookBtnBook.setOnClickListener {
            val intent = Intent(this, BookSecondActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBookSuccess(response: BookResponse) {
        if (response.code == 1000){

            val result = response.result
            binding.bookHotelName.text = result.name
            binding.bookInclusion.text = result.inclusion
            binding.bookPersonnel.text = result.personnel
            binding.bookHotelName.text = result.hotelName
            binding.bookText.text = result.text
            binding.bookPricebeforeSale.text = formatter.format(result.pricebeforeSale)
            binding.bookSaleRate.text = result.saleRate
            binding.bookPriceafterSale.text = formatter.format(result.priceafterSale)
            binding.boookInfo.text = result.info
            binding.bookReservationInfo.text = result.reservationInfo
            binding.bookCancelInfo.text = result.cancelInfo
            binding.bookPricebeforeSale.setPaintFlags(binding.bookPricebeforeSale.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)


            var BookList: List<BookImgUrl> = result.imageUrl
            binding.bookRoomHotizontal.layoutManager = LinearLayoutManager(this,  LinearLayoutManager.HORIZONTAL,false)
            var adapter = BookAdapter()
            adapter.listData.addAll(BookList)
            binding.bookRoomHotizontal.adapter = adapter

        }


    }

    override fun onBookFailure(message: String) {
        showCustomToast("오류 : $message")
    }
}