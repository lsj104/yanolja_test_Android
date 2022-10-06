package com.example.risingtest.src.main.search


import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySearchSecondBinding
import com.example.risingtest.src.main.search.models.*

class SearchSecondActivity : BaseActivity<ActivitySearchSecondBinding>(ActivitySearchSecondBinding::inflate),SearchActivityView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val searchKeyword = ApplicationClass.sSharedPreferences.getString("searchKeyword", "")
        binding.searchSecondEdt.setText(searchKeyword)

        val keyword = searchKeyword.toString()
        val startTime = "2021-08-25"
        val endTime = "2021-08-26"
        val adult = 2
        val child = 0
        val categoryid = "1,2"
        Log.d("categoryid", categoryid)
        SearchService(this).trySearch(keyword = keyword,startTime = startTime, endTime = endTime, adult = adult, child = child, categoryid = categoryid )
    }


    override fun onSearchSuccess(response: SearchResponse) {

        Log.d("SearchSecond1","1111")
        if(response.code == 1000){
            Log.d("SearchSecondActivity","1234")
            val result = response.result
            var searchList: List<Result> = result
            binding.searchSecondRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            var adapter = SearchSecondAdapter()
            adapter.listData.addAll(searchList)
            binding.searchSecondRecyclerView.adapter = adapter



        }
    }

    override fun onSearchFailure(message: String) {
        println(message)
        showCustomToast("오류 : $message")
    }


}