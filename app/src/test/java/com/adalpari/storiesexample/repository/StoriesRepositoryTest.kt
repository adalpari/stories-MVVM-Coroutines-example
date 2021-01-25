package com.adalpari.storiesexample.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.adalpari.storiesexample.network.datasource.DataSource
import com.adalpari.storiesexample.network.model.Photo
import com.adalpari.storiesexample.util.*
import com.adalpari.storiesview.model.StoriesSet
import com.adalpari.storiesview.model.Story
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.rules.TestRule
import org.mockito.Mockito.*

class StoriesRepositoryTest : TestCase() {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get: Rule
    val mainCoroutineScopeRule: MainCoroutineScopeRule = MainCoroutineScopeRule()

    fun `testShould return StorySet when correct call`() = mainCoroutineScopeRule.runBlockingTest {
        val count = randomSmallInt()
        val photos = generatePhotos(count)
        val expectedStorySet = photos.toStorySet()
        val dataSource = givenDatasource(photos)
        val storiesRepository = givenRepository(dataSource)

        val result = storiesRepository.getStories(count)

        assertEquals(expectedStorySet, result)
    }

    private suspend fun givenDatasource(photos: List<Photo>): DataSource {
        val dataSource: DataSource = mock(DataSource::class.java)
        whenever(dataSource.getRandomImages(eq(photos.size))).thenReturn(photos)
        return dataSource
    }
    private fun givenRepository(dataSource: DataSource): StoriesRepository = StoriesRepository(dataSource)

    private fun List<Photo>.toStorySet(): StoriesSet = StoriesSet(map { it.toStory() })

    private fun Photo.toStory(): Story = Story(0L, urls.regular, urls.thumb, false)
}