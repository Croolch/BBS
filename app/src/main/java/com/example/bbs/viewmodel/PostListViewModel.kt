package com.example.bbs.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbs.data.posts.PostListRepository
import com.example.bbs.model.PostList
import com.example.bbs.model.state.ModelState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class PostListViewModel: ViewModel() {
    var data: MutableState<ModelState<PostList>> = mutableStateOf(ModelState.Empty)
//    lateinit var listdata: PostList
//    fun dopostLogin(account: String, password: String) {
//        getLoginData(account, password)
//        Log.d("--viewmodel--", loginData.value.toString())
//    }

    fun getData(tab: String) {
        viewModelScope.launch {
            PostListRepository.getPostList(tab)
                .onStart {
                    data.value = ModelState.Loading
                }
                .catch { e ->
                    data.value = ModelState.Failure(e)
                    Log.d("--viewmodel--", e.toString())
                }
                .collect { response ->
                    data.value = ModelState.Success(response)
//                    listdata = response
                }
        }
    }
}