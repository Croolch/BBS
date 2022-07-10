package com.example.bbs.data.article

import com.example.bbs.data.network.AllApiClient
import com.example.bbs.model.ArticleData
import com.example.bbs.model.Signup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ArticleRepository {
    companion object {
        fun getArticle(id: Int): Flow<ArticleData> =
            flow {
                val articleinfo = AllApiClient.articlepageApiService.getArticlePage(id)
                emit(articleinfo)
            }.flowOn(Dispatchers.IO)
    }
}