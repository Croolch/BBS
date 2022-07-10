package com.example.bbs.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Author(
    @Json(name = "authorId")
    val authorId: Int,
    @Json(name = "authorName")
    val authorName: String,
    @Json(name = "avatar")
    val avatar: String,
    @Json(name = "discribe")
    val discribe: String
)