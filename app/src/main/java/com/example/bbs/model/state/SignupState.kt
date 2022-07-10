package com.example.bbs.model.state

import com.example.bbs.model.Signup

sealed class SignupState {
    class Success(val data: Signup): SignupState()
    class Failure(val error: Throwable): SignupState()
    object Loading: SignupState()
    object Empty: SignupState()
}