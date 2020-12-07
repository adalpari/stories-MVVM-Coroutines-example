package com.adalpari.storiesexample.repository

import com.adalpari.storiesview.model.StoriesSet

interface Repository {
    suspend fun getRandomImages(count: Int): StoriesSet
}