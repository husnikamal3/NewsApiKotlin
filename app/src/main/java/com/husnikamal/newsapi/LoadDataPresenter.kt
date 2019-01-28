package com.husnikamal.newsapi

import android.util.Log
import com.husnikamal.newsapi.model.Articles
import com.husnikamal.newsapi.network.RetrofitHelper
import com.husnikamal.newsapi.network.response.TopHeadlineResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadDataPresenter(private val view: ViewPresenter.View)
    : ViewPresenter.Presenter {

    val articles = arrayListOf<Articles>()

    init {
        this.view.setPresenter(this)
    }

    override fun loadData(country: String) {
        RetrofitHelper.getApiService().getTopHeadlines(country, BuildConfig.NEWS_API_KEY)
            .enqueue(object: Callback<TopHeadlineResponse> {
                override fun onResponse(call: Call<TopHeadlineResponse>?, response: Response<TopHeadlineResponse>?) {
                    if (response?.body() != null) {
                        for (a: Articles in response?.body().articles) {
                            articles.add(a)

                            Log.d("Huwiw", "" + a)
                        }

                        if (articles != null && articles.size > 0) {
                            view?.onSuccess(articles)
                        }
                    }
                }

                override fun onFailure(call: Call<TopHeadlineResponse>?, t: Throwable?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
    }
}