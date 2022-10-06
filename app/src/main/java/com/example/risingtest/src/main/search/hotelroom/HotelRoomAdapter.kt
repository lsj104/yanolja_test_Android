package com.example.risingtest.src.main.search.hotelroom


import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.risingtest.R
import com.example.risingtest.databinding.HotelRoomRecyclerItemBinding
import com.example.risingtest.src.main.search.book.BookActivity
import java.text.DecimalFormat

class HotelRoomAdapter: RecyclerView.Adapter<HotelRoomAdapter.HoomRoomHolder>() {




    val listData = mutableListOf<HotelResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoomRoomHolder {

        val binding = HotelRoomRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HoomRoomHolder(binding)

    }

    override fun onBindViewHolder(holder:HoomRoomHolder, position: Int) {
        val HotelRoom = listData.get(position)
        holder.SetHotelRoom(HotelRoom)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,BookActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent,null)
        }


    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class HoomRoomHolder(val binding: HotelRoomRecyclerItemBinding): RecyclerView.ViewHolder(binding.root){

        var formatter = DecimalFormat("###,###")
        fun SetHotelRoom(HotelRoom : HotelResult){



            val roomImg = itemView.findViewById<ImageView>(R.id.hotelroom_ry_img)
            Glide.with(itemView).load(HotelRoom.imageUrl).into(roomImg)
            binding.hotelroomRyName.text = HotelRoom.name
            binding.hotelroomInclusion.text = HotelRoom.inclusion
            binding.hotelroomCategory.text = HotelRoom.personnel
            binding.hotelroomBeforePrice.text = formatter.format(HotelRoom.pricebeforeSale)+"원"
            binding.hotelroomBeforePrice.setPaintFlags(binding.hotelroomBeforePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
            binding.hotelroomRealPrice.text = formatter.format(HotelRoom.priceafterSale)
            binding.hotelroomSale.text = HotelRoom.saleRate

        }
    }
}