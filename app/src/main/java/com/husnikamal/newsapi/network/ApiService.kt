package com.husnikamal.newsapi.network

import com.husnikamal.newsapi.network.response.TopHeadlineResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<TopHeadlineResponse>
}