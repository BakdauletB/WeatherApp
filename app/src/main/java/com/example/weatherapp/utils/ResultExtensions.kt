package com.example.weatherapp.utils

import retrofit2.Response

inline fun <T : Any> Response<T>.onSuccess(action: (T) -> Unit): Response<T> {
    val body = this.body()
    if (this.isSuccessful && body != null) action(body)
    return this
}

inline fun <T : Any> Response<T>.onError(action: () -> Unit): Response<T> {
    val errorBody = this.errorBody()
    if (!this.isSuccessful && errorBody != null) {
        action()
    }
    return this
}
