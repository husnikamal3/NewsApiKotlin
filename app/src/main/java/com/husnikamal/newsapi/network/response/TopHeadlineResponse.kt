package com.husnikamal.newsapi.network.response

import com.husnikamal.newsapi.model.Articles

class TopHeadlineResponse {
    lateinit var totalResults: String
    val articles = arrayListOf<Articles>()
    lateinit var status: String
}