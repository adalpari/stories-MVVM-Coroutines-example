package com.adalpari.storiesview.model

data class StoriesSet(val stories: List<Story>) {
    fun isViewed(): Boolean = stories.none { !it.isViewed }
}