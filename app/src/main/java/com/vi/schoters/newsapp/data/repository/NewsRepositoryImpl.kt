package com.vi.schoters.newsapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.vi.schoters.newsapp.data.source.NewsApi
import com.vi.schoters.newsapp.data.source.model.NewsResponse
import com.vi.schoters.newsapp.util.Result
import retrofit2.HttpException
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {

    override fun getNews(): LiveData<Result<NewsResponse>> = liveData {
        emit(Result.Loading)
        try {
            val data = api.getNews()
            emit(Result.Success(data))
        } catch (e: HttpException) {
            emit(Result.Error("Please check your connection"))
        } catch (e: Exception) {
            emit(Result.Error(e.localizedMessage?.toString() ?: "Unknown error"))
        }
    }
}