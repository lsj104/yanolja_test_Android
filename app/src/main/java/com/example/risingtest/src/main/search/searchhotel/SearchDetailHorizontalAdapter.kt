package com.example.risingtest.src.main.search.searchhotel

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.risingtest.R
import com.example.risingtest.databinding.SearchDetailHorizontalItemBinding
import com.example.risingtest.src.main.search.searchhotel.model.ImageUrl

class SearchDetailHorizontalAdapter: RecyclerView.Adapter<SearchDetailHorizontalAdapter.SearchDetailHolder>() {

    val listData = mutableListOf<ImageUrl>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDetailHolder {
        val binding = SearchDetailHorizontalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchDetailHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchDetailHolder, position: Int) {
        val searchHorezontal = listData.get(position)
        holder.setSearchDetailHorizontal(searchHorezontal)

    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class SearchDetailHolder(val binding: SearchDetailHorizontalItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun setSearchDetailHorizontal(searchHorezontal: ImageUrl){
            val img = itemView.findViewById<ImageView>(R.id.search_ry_detail_horizontal_item)
            Glide.with(itemView).load(searchHorezontal.imageUrl).into(img)

        }
    }
}