package com.adalpari.storiesexample.usecase

import com.adalpari.storiesexample.repository.StoriesRepository
import com.adalpari.storiesexample.util.retryOnError
import com.adalpari.storiesview.model.StoriesSet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetStoriesUseCase @Inject constructor(private val storiesRepository: StoriesRepository): IOUseCase<Int, StoriesSet> {

    override suspend fun call(input: Int): StoriesSet = storiesRepository.getStories(input)
}