package com.adalpari.storiesexample.datasource

import com.adalpari.storiesexample.model.UnsplashPhoto
import retrofit2.http.GET

interface UnsplashService {
    @GET("/photos/random/{count}")
    suspend fun getRandomPhotos(count: Int): List<UnsplashPhoto>
}