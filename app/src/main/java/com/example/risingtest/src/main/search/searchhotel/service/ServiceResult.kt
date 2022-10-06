package com.example.risingtest.src.main.search.searchhotel.service

import com.google.gson.annotations.SerializedName

data class ServiceResult (
        @SerializedName("facilityId") val  facilityId : Int,
        @SerializedName("hotelId") val  hotelId : Int,
        @SerializedName("name") val  name : String,
        @SerializedName("imageUrl") val  imageUrl : String
        )
