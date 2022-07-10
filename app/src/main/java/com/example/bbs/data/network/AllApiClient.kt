package com.example.bbs.data.network

import com.example.bbs.model.ArticleData
import com.example.bbs.model.Login
import com.example.bbs.model.PostList
import com.example.bbs.model.Signup
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

object AllApiClient {
    private const val BASE_URL = "http://47.52.147.105:22801/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val loginApiService: LoginApiService by lazy {
        retrofit.create(LoginApiService::class.java)
    }
    val signupApiService: SignupApiService by lazy {
        retrofit.create(SignupApiService::class.java)
    }
    val postlistApiService: PostListApiService by lazy {
        retrofit.create(PostListApiService::class.java)
    }
    val articlepageApiService: ArticlePageApiService by lazy {
        retrofit.create(ArticlePageApiService::class.java)
    }
}


interface LoginApiService{
    @POST("login")
    suspend fun getLoginData(
        @Query("account") account: String,
        @Query("password") password: String,
    ): Login
}

interface SignupApiService{
    @POST("signup")
    suspend fun getSingupData(
        @Query("account") account: String,
        @Query("password") password: String,
        @Query("userName") username: String,
    ): Signup
}

interface PostListApiService{
    @POST("home/")
    suspend fun getPostList(
        @Query("tab") tab: String,
    ): PostList
}

interface ArticlePageApiService{
    @POST("article/")
    suspend fun getArticlePage(
        @Query("id") id: Int,
    ): ArticleData
}