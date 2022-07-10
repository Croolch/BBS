package com.example.bbs.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Signup(
    @Json(name = "message")
    val message: String
)