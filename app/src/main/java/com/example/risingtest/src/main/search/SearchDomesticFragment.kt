package com.example.risingtest.src.main.search

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import com.example.risingtest.R
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentSearchDomesticBinding


class SearchDomesticFragment: BaseFragment<FragmentSearchDomesticBinding>(FragmentSearchDomesticBinding::bind, R.layout.fragment_search_domestic) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.searchEdt.setOnEditorActionListener { v, actionId, event ->
            val searchKeyword = binding.searchEdt.text.toString()
            val editor = ApplicationClass.sSharedPreferences.edit()
            editor.putString("searchKeyword", searchKeyword)
            editor.apply()
            val intent = Intent(requireActivity(), SearchSecondActivity::class.java)
            startActivity(intent)
            false
        }


    }
}