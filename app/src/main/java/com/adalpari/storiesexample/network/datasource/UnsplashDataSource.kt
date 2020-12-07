package com.adalpari.storiesexample.network.datasource

import com.adalpari.storiesexample.network.service.UnsplashService
import com.adalpari.storiesexample.network.model.Photo
import javax.inject.Inject

class UnsplashDataSource @Inject constructor(private val unsplashService: UnsplashService) :
    DataSource {
    override suspend fun getRandomImages(count: Int): List<Photo> = unsplashService.getRandomPhotos(count)
}