package com.example.risingtest.src.main.search.searchhotel.service

import android.util.Log
import com.example.risingtest.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceService(val view:ServiceView) {

    fun tryGetService(id: Int){
        val serviceRertofitInterface = ApplicationClass.sRetrofit.create(ServiceRertofitInterface::class.java)
        Log.d("ServiceTest","12345")

        serviceRertofitInterface.GetService(id).enqueue(object:Callback<ServiceResponse>{
            override fun onResponse(call: Call<ServiceResponse>, response: Response<ServiceResponse>) {
                view.onServiceSuccess(response.body() as ServiceResponse)
                Log.d("ServieSuccess", "12345")
            }

            override fun onFailure(call: Call<ServiceResponse>, t: Throwable) {
                view.onServiceFailure(t.message ?: "통신 오류")
                Log.d("SeviceFailure", "12345")
            }
        } )

    }
}