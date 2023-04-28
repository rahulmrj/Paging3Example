package com.example.paging3example.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3example.Models.Result
import com.example.paging3example.retrofit.QuotesAPI

class QuotesPagingSource( val quotesAPI: QuotesAPI) : PagingSource<Int, Result>() {



    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        try {
            val position = params.key ?: 1
            val response = quotesAPI.getQuotes(position)
            return LoadResult.Page(
                data = response.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1
            )
        } catch (e: java.lang.Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
        /**
         * Below code is  Explanotroy version
         */
//        if (state.anchorPosition != null){
//           val anchorPage = state.closestPageToPosition(state.anchorPosition!!)
//            if(anchorPage?.prevKey != null){
//                return anchorPage.prevKey!!.plus(1)
//            }else if (anchorPage?.nextKey != null){
//                return anchorPage?.nextKey!!.minus(1)
//            }
//            else{
//                return 1
//            }
//        }else
//            return null
    }
}