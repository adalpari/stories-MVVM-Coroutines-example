package com.adalpari.storiesexample.datasource

import com.adalpari.storiesexample.model.UnsplashPhoto
import retrofit2.http.GET
import retrofit2.http.Path

interface UnsplashService {
    @GET("/photos/random/{count}")
    suspend fun getRandomPhotos(@Path("count")  count: Int): List<UnsplashPhoto>
}