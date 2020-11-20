package com.adalpari.storiesexample.viewmodel

import com.adalpari.storiesview.model.StoriesSet

sealed class UiState {
    object Loading : UiState()
    data class Success(val entries: List<StoriesSet>) : UiState()
    data class Error(val message: String) : UiState()
}