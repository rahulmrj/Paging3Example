package com.example.paging3example.retrofit

import com.example.paging3example.Models.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesAPI {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page : Int): QuoteList
}