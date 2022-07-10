package com.example.bbs.model.state

sealed class ModelState<out R> {
    data class Success<out T>(val data: T) : ModelState<T>()
    data class Failure(val error: Throwable) : ModelState<Nothing>()
    object Loading : ModelState<Nothing>()
    object Empty : ModelState<Nothing>()
}