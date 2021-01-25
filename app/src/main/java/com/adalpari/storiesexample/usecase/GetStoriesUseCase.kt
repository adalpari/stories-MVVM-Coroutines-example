package com.adalpari.storiesexample.usecase

import com.adalpari.storiesexample.repository.StoriesRepository
import com.adalpari.storiesexample.util.DispatcherProvider
import com.adalpari.storiesview.model.StoriesSet
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetStoriesUseCase @Inject constructor(
    private val storiesRepository: StoriesRepository,
    private val dispatchersProvider: DispatcherProvider
    ): SuspendUseCase<Int, StoriesSet> {
    override suspend fun call(input: Int): StoriesSet =
        withContext(dispatchersProvider.getIO()) {
            storiesRepository.getStories(input)
        }
}