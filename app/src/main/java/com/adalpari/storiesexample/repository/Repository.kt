package com.adalpari.storiesexample.repository

import com.adalpari.storiesexample.model.UnsplashPhoto

interface Repository {
    suspend fun getRandomImages(count: Int): List<UnsplashPhoto>
}