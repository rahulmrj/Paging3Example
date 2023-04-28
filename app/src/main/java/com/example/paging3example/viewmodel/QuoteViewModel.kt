package com.example.paging3example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.paging3example.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Scope

@HiltViewModel
class QuoteViewModel @Inject constructor(val quoteRepository: QuoteRepository) : ViewModel(){

    val quoteList = quoteRepository.getQuotes().cachedIn(viewModelScope)
}