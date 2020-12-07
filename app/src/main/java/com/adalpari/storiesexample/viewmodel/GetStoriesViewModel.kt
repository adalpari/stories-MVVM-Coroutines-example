package com.adalpari.storiesexample.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.adalpari.storiesexample.repository.StoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class GetStoriesViewModel @ViewModelInject constructor(private val storiesRepository: StoriesRepository) : BaseViewModel<UiState>() {

    fun getStories() {
        uiState.value = UiState.Loading

        viewModelScope.launch(context = Dispatchers.IO) {
            try {
                val stories = (0..getRandomStoriesNumber()).map {
                    async { storiesRepository.getRandomImages(getRandomStoriesNumber()) }
                }.awaitAll()

                uiState.value = UiState.Success(stories)
            } catch (exception: Exception) {
                uiState.value = UiState.Error("Error retrieving stories")
            }
        }
    }

    private fun getRandomStoriesNumber() = (1..5).random()
}