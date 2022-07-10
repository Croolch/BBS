package com.example.bbs.data.login

import com.example.bbs.data.network.AllApiClient
import com.example.bbs.model.Signup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SignupRepository {
    companion object {
        fun getSignup(account: String, password: String, username: String): Flow<Signup> =
            flow {
                val signupinfo = AllApiClient.signupApiService.getSingupData(account, password, username)
                emit(signupinfo)
            }.flowOn(Dispatchers.IO)
    }
}