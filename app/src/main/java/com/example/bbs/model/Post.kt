package com.example.bbs.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    @Json(name = "author")
    val author: String,
    @Json(name = "comments")
    val comments: Int,
    @Json(name = "id")
    val id: Int,
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