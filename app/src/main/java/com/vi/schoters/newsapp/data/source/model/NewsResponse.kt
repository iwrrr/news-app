package com.vi.schoters.newsapp.data.source.model

data class NewsResponse(
    val articles: MutableList<NewsArticle>,
    val status: String,
    val totalResults: Int
)