package com.example.bbs.data.login

import com.example.bbs.data.network.AllApiClient
import com.example.bbs.model.Login
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LoginRepository {
    companion object {
        fun getLogin(account: String, password: String): Flow<Login> =
            flow {
                val logininfo = AllApiClient.loginApiService.getLoginData(account, password)
                emit(logininfo)
            }.flowOn(Dispatchers.IO)
    }
}
