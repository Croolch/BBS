package com.example.bbs.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostList(
    @Json(name = "posts-list")
    val postsList: List<Post>
)