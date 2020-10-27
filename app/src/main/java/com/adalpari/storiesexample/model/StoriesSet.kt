package com.adalpari.storiesexample.model

data class StoriesSet(val stories: List<Story>) {
    fun isViewed(): Boolean = stories.none { !it.isViewed }
}