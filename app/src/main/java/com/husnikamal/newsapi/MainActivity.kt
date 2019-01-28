package com.husnikamal.newsapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.husnikamal.newsapi.model.Articles
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewPresenter.View {

    private lateinit var mPresenter: ViewPresenter.Presenter
    private lateinit var adapter: ArticleAdapter
    private lateinit var articleList: ArrayList<Articles>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoadDataPresenter(this)

        articleList = arrayListOf()
        adapter = ArticleAdapter(articleList, this)

        rcv_news.layoutManager = LinearLayoutManager(this)
        rcv_news.adapter = adapter
    }

    override fun setPresenter(presenter: ViewPresenter.Presenter) {
        this.mPresenter = presenter
        this.mPresenter.loadData("id")
    }

    override fun onSuccess(data: ArrayList<Articles>) {
        Log.d("Huwiw", "Triggered")
        for (a: Articles in data) {
            articleList.add(a)
        }
        adapter.notifyDataSetChanged()
    }
}
