package com.vi.schoters.newsapp.data.repository

import androidx.lifecycle.LiveData
import com.vi.schoters.newsapp.data.source.model.NewsResponse
import com.vi.schoters.newsapp.util.Result

interface NewsRepository {

    fun getNews(): LiveData<Result<NewsResponse>>
}