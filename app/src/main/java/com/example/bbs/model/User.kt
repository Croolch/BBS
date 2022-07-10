package com.example.bbs.model

data class User(
    val id: String,
    val name: String,
    val avatar: String,
    val discribe: String,
    val articles: Int,
    val comments: Int,
    val subscribe: Int,
    val collect: Int,
    val votes: Int,
    val recieve_comments: Int,
    val recieve_votes: Int,
    val recieve_collect: Int,
    val recieve_subscribe: Int
)
