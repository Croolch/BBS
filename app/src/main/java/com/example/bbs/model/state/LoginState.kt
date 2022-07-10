package com.example.bbs.model.state

import com.example.bbs.model.Login

sealed class LoginState {
    class Success(val login: Login): LoginState()
    class Failure(val error: Throwable): LoginState()
    object Loading: LoginState()
    object Empty: LoginState()
}