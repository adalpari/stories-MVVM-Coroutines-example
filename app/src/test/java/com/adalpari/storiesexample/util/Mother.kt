package com.adalpari.storiesexample.util

import com.adalpari.storiesexample.network.model.Photo
import com.adalpari.storiesexample.network.model.Urls
import com.adalpari.storiesview.model.StoriesSet
import com.adalpari.storiesview.model.Story
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextInt
import kotlin.random.Random.Default.nextLong

private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

fun generateStoriesSet(count: Int): StoriesSet =
    StoriesSet(generateStories(count))

fun generateStories(count: Int): List<Story> =
    (1..count).map { Story(randomLong(), randomString(), randomString(), randomBoolean()) }

fun generatePhotos(count: Int): List<Photo> =
    (1..count).map { Photo(randomString(), randomString(), generateUrls()) }

fun generateUrls(): Urls = Urls(randomString(), randomString())

fun randomLong(): Long = nextLong()

fun randomBoolean(): Boolean = nextBoolean()

fun randomSmallInt() = (0..100).random()

fun randomString(size: Int = 20): String = (0..size)
    .map { charPool[nextInt(0, charPool.size)] }
    .joinToString()