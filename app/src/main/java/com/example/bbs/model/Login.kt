package com.example.bbs.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Login(
    @Json(name = "account")
    val account: String,
    @Json(name = "avatar")
    val avatar: String,
    @Json(name = "expiresIn")
    val expiresIn: Int,
    @Json(name = "idToken")
    val idToken: String,
    @Json(name = "message")
    val message: String,
    @Json(name = "userName")
    val userName: String
)