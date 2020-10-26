package com.adalpari.storiesexample.usecase

import com.adalpari.storiesexample.model.StoriesSet
import com.adalpari.storiesexample.model.Story

class GetStoriesUseCase: UseCase<GetStoriesUseCase.Input, GetStoriesUseCase.Output> {

    override fun execute(input: Input, callback: UseCase.Callback<Output>) {
        // This is a mock use case. We just return a static response
        val storiesSet1 = createStoriesSet(listOf(
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/bady-abbas-VmYZe_yqxL0-unsplash.jpg",
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/carson-arias-7Z03R1wOdmI-unsplash.jpg",
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/gian-cescon-ilUWHlGndAA-unsplash.jpg"
        ))

        val storiesSet2 = createStoriesSet(listOf(
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/jed-villejo-4SByp8kIoOE-unsplash.jpg",
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/nadine-shaabana-x4GylZ-ZhjI-unsplash.jpg"

        ))
        val storiesSet3 = createStoriesSet(listOf(
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/nathan-dumlao-eUbNeGQEh2U-unsplash.jpg"
        ))
        val storiesSet4 = createStoriesSet(listOf(
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/olia-nayda-Lq0HQ_IKfvw-unsplash.jpg",
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/nathan-mcbride-U9cy1BCLql0-unsplash.jpg",
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/richard-jaimes-k4dT8x2--gI-unsplash.jpg",
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/zane-lee-5hC0sRUB5T0-unsplash.jpg"

        ))
        val storiesSet5 = createStoriesSet(listOf(
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/sandi-camarin-8DBaxAhmxqI-unsplash.jpg",
            "https://raw.githubusercontent.com/adalpari/stories-example/main/assets-images/oliver-sjostrom-iSrBg45UCaM-unsplash.jpg"
        ))

        callback.onResponse(Output(listOf(storiesSet1, storiesSet2, storiesSet3, storiesSet4, storiesSet5)))
    }

    private fun createStoriesSet(contentUrls: List<String>): StoriesSet =
        StoriesSet(contentUrls.map { Story(System.currentTimeMillis(), it, false) })

    class Input
    class Output(val entries: List<StoriesSet>)
}