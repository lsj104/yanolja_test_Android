    package com.example.risingtest.src.main.search.models

    import android.content.Intent
    import android.graphics.Paint
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.core.content.ContextCompat
    import androidx.recyclerview.widget.RecyclerView
    import com.bumptech.glide.Glide
    import com.example.risingtest.R
    import com.example.risingtest.databinding.SearchSecondItemBinding
    import com.example.risingtest.src.main.search.searchhotel.SearchDetailActivity
    import java.text.DecimalFormat

    class SearchSecondAdapter: RecyclerView.Adapter<SearchSecondAdapter.SearchHolder>() {

        val listData = mutableListOf<Result>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
            val binding = SearchSecondItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return SearchHolder(binding)
        }

        override fun onBindViewHolder(holder: SearchHolder, position: Int) {
            val search = listData.get(position)
            holder.setSearch(search)

            holder.itemView.setOnClickListener{
                val intent = Intent(holder.itemView.context, SearchDetailActivity::class.java)
                intent.putExtra("id", listData.get(position).id)
                ContextCompat.startActivity(holder.itemView.context, intent,null)
            }
        }

        override fun getItemCount(): Int {
            return listData.size
        }

        class SearchHolder(val binding: SearchSecondItemBinding): RecyclerView.ViewHolder(binding.root){
            var formatter = DecimalFormat("###,###")
            fun setSearch(search: Result){
                val img = itemView.findViewById<ImageView>(R.id.search_ry_img)
                binding.searchRating.rating = search.reviewScore.toFloat()
                binding.searchRyName.text = search.name
                Glide.with(itemView).load(search.imageUrl).into(img)
                binding.searchRatingScore.text = search.reviewScore
                binding.searchReviewCount.text = "(" + search.reviewCount.toString() +")"
                binding.searchCategory.text= search.categoryName
                binding.searchBeforePrice.setPaintFlags(binding.searchBeforePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
                binding.searchStartTime.text = search.kindText
                binding.searchBeforePrice.text = formatter.format(search.pricebeforeSale)+"원"
                binding.searchSale.text = search.saleRate+"~"
                binding.searchRealPrice.text = formatter.format(search.priceafterSale)

            }
        }


    }