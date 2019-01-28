package com.husnikamal.newsapi

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.husnikamal.newsapi.model.Articles
import kotlinx.android.synthetic.main.article_layout.view.*

class ArticleAdapter(
    private val data: List<Articles>,
    private val mContext: Context
    ): RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(LayoutInflater.from(mContext)
            .inflate(R.layout.article_layout, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    open class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(articles: Articles) {
            itemView.tv_title.text = articles.title
            itemView.tv_author.text = articles.author
            itemView.tv_description.text = articles.description
            Glide.with(itemView)
                .load(articles.urlToImage)
                .into(itemView.img_banner)

            itemView.card_container.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("url", articles.url)
                context.startActivity(intent)
            }
        }
    }

}