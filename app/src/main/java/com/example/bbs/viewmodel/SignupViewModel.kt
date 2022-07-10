package com.example.bbs.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbs.data.login.LoginRepository
import com.example.bbs.data.login.SignupRepository
import com.example.bbs.model.Signup
import com.example.bbs.model.state.LoginState
import com.example.bbs.model.state.ModelState
import com.example.bbs.model.state.SignupState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class SignupViewModel: ViewModel() {
    var signupData: MutableState<ModelState<Signup>> = mutableStateOf(ModelState.Empty)

//    fun dopostLogin(account: String, password: String) {
//        getLoginData(account, password)
//        Log.d("--viewmodel--", loginData.value.toString())
//    }

    fun getSignupData(account: String, password: String, username: String) {
        viewModelScope.launch {
            SignupRepository.getSignup(account, password, username)
                .onStart {
                    signupData.value = ModelState.Loading
                }
                .catch { e ->
                    signupData.value = ModelState.Failure(e)
                    Log.d("--viewmodel--", e.toString())
                }
                .collect { response ->
                    signupData.value = ModelState.Success(response)
                }
        }
    }
}