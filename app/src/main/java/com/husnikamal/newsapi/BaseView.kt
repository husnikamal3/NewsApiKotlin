package com.husnikamal.newsapi

import com.husnikamal.newsapi.model.Articles

interface BaseView<T> {
    fun setPresenter(presenter: T)
    fun onSuccess(data: ArrayList<Articles>)
}