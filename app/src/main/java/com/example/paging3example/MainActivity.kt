package com.example.paging3example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3example.paging.QuotePagingAdapter
import com.example.paging3example.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var quotePagingAdapter: QuotePagingAdapter
    lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewID)
        quotePagingAdapter = QuotePagingAdapter()
        quoteViewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = quotePagingAdapter

        quoteViewModel.quoteList.observe(this, Observer {
            quotePagingAdapter.submitData(lifecycle, it )
        })
    }
}