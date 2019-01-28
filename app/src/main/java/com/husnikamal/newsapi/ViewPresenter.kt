package com.husnikamal.newsapi

class ViewPresenter {
    interface View: BaseView<Presenter> {}
    interface Presenter: BasePresenter {
        fun loadData(country: String)
    }
}