package com.adalpari.storiesexample.network.service

import com.adalpari.storiesexample.network.model.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashService {
    @GET("/photos/random")
    suspend fun getRandomPhotos(@Query("count")  count: Int): List<Photo>
}