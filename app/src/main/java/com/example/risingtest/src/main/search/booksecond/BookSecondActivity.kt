package com.example.risingtest.src.main.search.booksecond

import android.content.Intent
import android.os.Bundle
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityBookSecondBinding
import com.example.risingtest.src.main.search.book.BookActivityView
import com.example.risingtest.src.main.search.book.BookResponse
import com.example.risingtest.src.main.search.book.BookService
import com.example.risingtest.src.main.search.bookthird.BookThirdActivity
import java.text.DecimalFormat

class BookSecondActivity : BaseActivity<ActivityBookSecondBinding>(ActivityBookSecondBinding::inflate), BookActivityView {

    var formatter = DecimalFormat("###,###")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = 1
        val startTime = "2021-08-16"
        val endTime = "2021-08-18"
        BookService(this).tryGetBook(id, startTime = startTime, endTime = endTime)

        binding.bookSecondBtnNext.setOnClickListener {
            val intent = Intent(this, BookThirdActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBookSuccess(response: BookResponse) {

        if (response.code == 1000) {
            val result = response.result
            binding.bookSecondName.text = result.name
            binding.bookSecondPersonnel.text = result.personnel
            binding.bookSecondCancelInfo.text = result.cancelInfo
            binding.bookSecondPriceafterSale.text = formatter.format(result.priceafterSale)
        }
    }

    override fun onBookFailure(message: String) {
        showCustomToast("오류 : $message")
    }

}

