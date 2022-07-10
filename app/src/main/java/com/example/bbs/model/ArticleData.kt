package com.example.bbs.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleData(
    @Json(name = "article")
    val article: Article,
    @Json(name = "author")
    val author: Author,
    @Json(name = "id")
    val id: Int
)