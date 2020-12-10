package com.adalpari.storiesexample.repository

import com.adalpari.storiesexample.network.datasource.DataSource
import com.adalpari.storiesexample.network.model.Photo
import com.adalpari.storiesview.model.StoriesSet
import com.adalpari.storiesview.model.Story
import javax.inject.Inject

class StoriesRepository @Inject constructor(private val dataSource: DataSource): Repository {
    // TODO use a cache and timer

    override suspend fun getStories(count: Int): StoriesSet = dataSource.getRandomImages(count).toStorySet()

    private fun List<Photo>.toStorySet():StoriesSet  = StoriesSet(map { it.toStory() })

    private fun Photo.toStory(): Story = Story(0L, urls.regular, urls.thumb, false)
}