package com.example.risingtest.src.main.search.book

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.risingtest.R
import com.example.risingtest.databinding.BookRecyclerItemBinding

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookHolder>() {

    val listData = mutableListOf<BookImgUrl>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val binding = BookRecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BookHolder(binding)
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val booklist =  listData.get(position)
        holder.setBook(booklist)

    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class BookHolder(val binding: BookRecyclerItemBinding): RecyclerView.ViewHolder(binding.root){
     fun setBook(booklist: BookImgUrl){
         val img = itemView.findViewById<ImageView>(R.id.book_recycler_imgView)
         Glide.with(itemView).load(booklist.imageUrl).into(img)
     }
    }
}