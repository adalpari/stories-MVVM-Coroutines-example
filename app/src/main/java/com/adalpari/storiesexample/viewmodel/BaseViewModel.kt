package com.adalpari.storiesexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adalpari.storiesexample.usecase.SuspendUseCase
import com.adalpari.storiesexample.util.retryOnError

open class BaseViewModel<T> : ViewModel() {

    fun uiState(): LiveData<T> = uiState
    protected val uiState: MutableLiveData<T> = MutableLiveData()

    suspend fun <I, O>call(suspendUseCase: SuspendUseCase<I, O>, input: I): O = suspendUseCase.call(input)

    suspend fun <I, O>callRetry(suspendUseCase: SuspendUseCase<I, O>, input: I): O =
        retryOnError {
            suspendUseCase.call(input)
        }
}