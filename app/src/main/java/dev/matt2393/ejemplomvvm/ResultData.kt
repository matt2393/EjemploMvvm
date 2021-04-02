package dev.matt2393.ejemplomvvm

sealed class ResultData<out R> {
    data class Success<out T>(val data: T): ResultData<T>()
    data class Error(val ex: Exception): ResultData<Nothing>()
}