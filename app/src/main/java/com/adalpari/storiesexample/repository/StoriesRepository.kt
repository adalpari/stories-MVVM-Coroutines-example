package com.adalpari.storiesexample.repository

import com.adalpari.storiesexample.datasource.DataSource
import com.adalpari.storiesexample.model.UnsplashPhoto
import com.adalpari.storiesview.model.StoriesSet
import com.adalpari.storiesview.model.Story
import javax.inject.Inject

class StoriesRepository @Inject constructor(private val dataSource: DataSource): Repository {
    // TODO use a cache and timer

    override suspend fun getRandomImages(count: Int): StoriesSet = dataSource.getRandomImages(count).toStorySet()

    // TODO: Map it in a better way
    private fun List<UnsplashPhoto>.toStorySet():StoriesSet  = StoriesSet(map { it.toStory() })

    private fun UnsplashPhoto.toStory(): Story = Story(0L, urls.regular, urls.thumb, false)
}