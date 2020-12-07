package com.adalpari.storiesexample.datasource

import com.adalpari.storiesexample.model.UnsplashPhoto

interface DataSource {
    suspend fun getRandomImages(count: Int): List<UnsplashPhoto>
}