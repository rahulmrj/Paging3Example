package com.example.paging3example.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3example.Models.Result
import com.example.paging3example.R
import java.util.zip.Inflater

class QuotePagingAdapter : PagingDataAdapter<Result, QuotePagingAdapter.QuoteViewHolder>(COMPRATOR) {

    companion object {
        private val COMPRATOR = object : DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item = getItem(position)
        if(item != null){
            holder.quote.setText(item.content)
            val dash = "- " + item.author
            holder.author.setText(dash)
        }
    }



    class QuoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val quote = itemView.findViewById<TextView>(R.id.quoteTv)
        val author = itemView.findViewById<TextView>(R.id.quoteAuthor)

    }
}