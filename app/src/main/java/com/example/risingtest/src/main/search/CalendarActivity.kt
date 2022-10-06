package com.example.risingtest.src.main.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrewjapar.rangedatepicker.CalendarPicker
import com.example.risingtest.R
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val startDate = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault())
        val endDate = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault())
        endDate.add(Calendar.MONTH, 6) // Add 6 months ahead from current date




    }
}