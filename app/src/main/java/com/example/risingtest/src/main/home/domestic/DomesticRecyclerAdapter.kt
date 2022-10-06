package com.example.risingtest.src.main.home.domestic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.R
import com.example.risingtest.src.main.home.domestic.models.DomesticResult

class DomesticRecyclerAdapter (private val DomesticList: List<DomesticResult>) : RecyclerView.Adapter<DomesticRecyclerAdapter.CustomViewHolder>(){
    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.do_ry_text)
        val score = itemView.findViewById<TextView>(R.id.rc_rating_score)
        val review = itemView.findViewById<TextView>(R.id.do_ry_review)
        val price = itemView.findViewById<TextView>(R.id.ry_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.domestic_recyclerview_item,parent,false)
        return CustomViewHolder(view).apply{}
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.name.text = DomesticList.get(position).name
        holder.score.text = DomesticList.get(position).reviewScore
        holder.review.text = DomesticList.get(position).reviewCount.toString()

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}