package com.husnikamal.newsapi.model

class Articles {
    val publishedAt: String? = null
    val author: String? = null
    val urlToImage: String? = null
    val description: String? = null
    val source: Source? = null
    val title: String? = null
    val url: String? = null
    val content: String? = null

    override fun toString(): String {
        return "Articles : { publishedAt: " + publishedAt +
                ", author: " + if (author != null) author else "null" +
                ", urlToImage: " + if (urlToImage != null) urlToImage else "null" +
                ", description: " + if (description != null) description else "null" +
                ", source: " + if (source != null) source else "null" +
                ", title: " + if (title != null) title else "null" +
                ", url: " + if (url != null) url else "null" +
                ", content: " + if (content != null) content else "null" + "}"
    }
}