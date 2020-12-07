package com.adalpari.storiesexample.datasource

import com.adalpari.storiesexample.model.UnsplashPhoto
import javax.inject.Inject

class UnsplashDataSource @Inject constructor(private val unsplashService: UnsplashService) : DataSource {
    override suspend fun getRandomImages(count: Int): List<UnsplashPhoto> = unsplashService.getRandomPhotos(count)
}