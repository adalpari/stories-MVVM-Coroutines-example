package com.adalpari.storiesexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adalpari.storiesexample.usecase.IOUseCase
import com.adalpari.storiesexample.util.retryOnError
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

open class BaseViewModel<T> : ViewModel() {

    fun uiState(): LiveData<T> = uiState
    protected val uiState: MutableLiveData<T> = MutableLiveData()

    suspend fun <I, O>call(ioUseCase: IOUseCase<I, O>, input: I): O = ioUseCase.call(input)

    suspend fun <I, O>callRetry(ioUseCase: IOUseCase<I, O>, input: I): O =
        retryOnError {
            ioUseCase.call(input)
        }
}