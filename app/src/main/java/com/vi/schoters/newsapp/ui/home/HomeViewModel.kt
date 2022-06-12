package com.vi.schoters.newsapp.ui.home

import androidx.lifecycle.ViewModel
import com.vi.schoters.newsapp.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    fun getNews() = repository.getNews()
}