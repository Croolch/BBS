package com.example.bbs.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbs.data.article.ArticleRepository
import com.example.bbs.data.login.LoginRepository
import com.example.bbs.data.login.SignupRepository
import com.example.bbs.model.ArticleData
import com.example.bbs.model.Signup
import com.example.bbs.model.state.LoginState
import com.example.bbs.model.state.ModelState
import com.example.bbs.model.state.SignupState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ArticleViewModel: ViewModel() {
    var data: MutableState<ModelState<ArticleData>> = mutableStateOf(ModelState.Empty)

    fun getArticleData(id: Int) {
        viewModelScope.launch {
            ArticleRepository.getArticle(id)
                .onStart {
                    data.value = ModelState.Loading
                }
                .catch { e ->
                    data.value = ModelState.Failure(e)
                    Log.d("--viewmodel--", e.toString())
                }
                .collect { response ->
                    data.value = ModelState.Success(response)
                }
        }
    }
}