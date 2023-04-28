package com.example.paging3example.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.paging3example.paging.QuotesPagingSource
import com.example.paging3example.retrofit.QuotesAPI
import javax.inject.Inject

class QuoteRepository @Inject constructor(val quotesAPI: QuotesAPI) {

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {QuotesPagingSource(quotesAPI)}
    ).liveData
}