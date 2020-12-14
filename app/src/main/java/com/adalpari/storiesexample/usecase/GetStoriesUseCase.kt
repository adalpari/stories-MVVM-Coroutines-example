package com.adalpari.storiesexample.usecase

import com.adalpari.storiesexample.repository.StoriesRepository
import com.adalpari.storiesview.model.StoriesSet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetStoriesUseCase @Inject constructor(private val storiesRepository: StoriesRepository): SuspendUseCase<Int, StoriesSet> {
    override suspend fun call(input: Int): StoriesSet =
        withContext(Dispatchers.IO) {
            storiesRepository.getStories(input)
        }

}