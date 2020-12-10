package com.adalpari.storiesexample.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.adalpari.storiesexample.usecase.GetStoriesUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class GetStoriesViewModel @ViewModelInject constructor(private val getStoriesUseCase: GetStoriesUseCase) : BaseViewModel<UiState>() {

    fun getStories() {
        viewModelScope.launch {
            try {
                uiState.value = UiState.Loading

                val stories = (0..getRandomStoriesNumber()).map {
                    async {
                        getStoriesUseCase.call(getRandomStoriesNumber())
                    }
                }.awaitAll()

                uiState.value = UiState.Success(stories)
            } catch (exception: Exception) {
                uiState.value = UiState.Error("Error retrieving stories")
            }
        }
    }

    private fun getRandomStoriesNumber() = (1..5).random()
}