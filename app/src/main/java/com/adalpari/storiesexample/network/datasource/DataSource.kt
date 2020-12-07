package com.adalpari.storiesexample.network.datasource

import com.adalpari.storiesexample.network.model.Photo

interface DataSource {
    suspend fun getRandomImages(count: Int): List<Photo>
}