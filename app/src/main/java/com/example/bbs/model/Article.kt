package com.example.bbs.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Article(
    @Json(name = "comments")
    val comments: Int,
    @Json(name = "content")
    val content: String,
    @Json(name = "postDate")
    val postDate: String,
    @Json(name = "tags")
    val tags: List<String>,
    @Json(name = "title")
    val title: String,
    @Json(name = "views")
    val views: Int,
    @Json(name = "votes")
    val votes: Int
)