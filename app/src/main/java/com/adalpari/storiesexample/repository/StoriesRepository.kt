package com.adalpari.storiesexample.repository

import com.adalpari.storiesexample.datasource.DataSource
import com.adalpari.storiesexample.model.UnsplashPhoto
import javax.inject.Inject

class StoriesRepository @Inject constructor(private val dataSource: DataSource): Repository {
    // TODO use a cache and timer

    override suspend fun getRandomImages(count: Int): List<UnsplashPhoto> {
        //TODO: MAP images
        return dataSource.getRandomImages(count)
    }
}