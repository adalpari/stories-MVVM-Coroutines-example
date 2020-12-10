package com.adalpari.storiesexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adalpari.storiesexample.usecase.IOUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseViewModel<T> : ViewModel() {

    fun uiState(): LiveData<T> = uiState
    protected val uiState: MutableLiveData<T> = MutableLiveData()

    suspend fun <I, O>call(ioUseCase: IOUseCase<I, O>, input: I): O =
        withContext(Dispatchers.IO) {
            ioUseCase.call(input)
        }
}