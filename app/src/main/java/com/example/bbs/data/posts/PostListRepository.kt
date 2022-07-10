package com.example.bbs.data.posts

import com.example.bbs.data.network.AllApiClient
import com.example.bbs.model.PostList
import com.example.bbs.model.Signup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostListRepository {
    companion object {
        fun getPostList(tab: String): Flow<PostList> =
            flow {
                val postlist = AllApiClient.postlistApiService.getPostList(tab)
                emit(postlist)
            }.flowOn(Dispatchers.IO)
    }
}