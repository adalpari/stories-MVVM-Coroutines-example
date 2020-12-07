package com.adalpari.storiesexample.repository

import com.adalpari.storiesview.model.StoriesSet

interface Repository {
    suspend fun getStories(count: Int): StoriesSet
}