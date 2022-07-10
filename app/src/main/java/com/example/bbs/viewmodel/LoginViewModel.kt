package com.example.bbs.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbs.data.login.LoginRepository
import com.example.bbs.model.state.LoginState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    var loginData: MutableState<LoginState> = mutableStateOf(LoginState.Empty)

//    fun dopostLogin(account: String, password: String) {
//        getLoginData(account, password)
//        Log.d("--viewmodel--", loginData.value.toString())
//    }

    fun getLoginData(account: String, password: String) {
        viewModelScope.launch {
            LoginRepository.getLogin(account, password)
                .onStart {
                    loginData.value = LoginState.Loading
                }
                .catch { e ->
                    loginData.value = LoginState.Failure(e)
                    Log.d("--viewmodel--", e.toString())
                }
                .collect { response ->
                    loginData.value = LoginState.Success(response)
                }
        }
    }
}