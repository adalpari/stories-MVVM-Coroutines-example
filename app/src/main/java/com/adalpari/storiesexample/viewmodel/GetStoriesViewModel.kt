package com.adalpari.storiesexample.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adalpari.storiesexample.usecase.GetStoriesUseCase
import com.adalpari.storiesview.model.StoriesSet
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class GetStoriesViewModel @ViewModelInject constructor(private val getStoriesUseCase: GetStoriesUseCase) : BaseViewModel<StoriesState>() {

    fun getStories() {
        uiState.value = StoriesState.Loading

        viewModelScope.launch {
            try {
                val stories = (0..getRandomStoriesNumber()).map {
                    async {
                        callRetry(getStoriesUseCase, getRandomStoriesNumber())
                    }
                }.awaitAll()

                uiState.value = StoriesState.Success(stories)
            } catch (exception: Exception) {
                uiState.value = StoriesState.Error("Error retrieving stories")
            }
        }
    }

    private fun getRandomStoriesNumber() = (1..5).random()
}

sealed class StoriesState {
    object Loading : StoriesState()
    data class Success(val entries: List<StoriesSet>) : StoriesState()
    data class Error(val message: String) : StoriesState()
}