package com.vi.schoters.newsapp.data.source

import com.vi.schoters.newsapp.data.source.model.NewsResponse
import retrofit2.http.GET

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getNews(): NewsResponse
}