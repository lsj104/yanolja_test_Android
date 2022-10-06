package com.example.risingtest.src.main.search.searchhotel.service
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.risingtest.R
import com.example.risingtest.databinding.HotleRoomServiceItemBinding


class ServiceAdapter : RecyclerView.Adapter<ServiceAdapter.ServiceHolder>(){

    val listData = mutableListOf<ServiceResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceHolder {
        val binding = HotleRoomServiceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServiceHolder(binding)
    }

    override fun onBindViewHolder(holder: ServiceHolder, position: Int) {
        val Service =  listData.get(position)
        holder.setService(Service)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ServiceHolder(val binding: HotleRoomServiceItemBinding):RecyclerView.ViewHolder(binding.root){
        fun setService(Service: ServiceResult){
             val serviceImg = itemView.findViewById<ImageView>(R.id.hotel_service_icon)
             Glide.with(itemView).load(Service.imageUrl).into(serviceImg)
             binding.hotelServiceText.text = Service.name
        }
    }
}