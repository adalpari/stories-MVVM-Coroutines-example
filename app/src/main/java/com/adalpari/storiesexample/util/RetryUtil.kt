package com.adalpari.storiesexample.util

import kotlinx.coroutines.delay

private const val MAX_RETRIES = 2
private const val INITIAL_DELAY_MILLIS = 100L
private const val MAX_DELAY_MILLIS = 1000L
private const val DELAY_FACTOR = 2.0

suspend fun <T> retryOnError(
    times: Int = MAX_RETRIES,
    initialDelayMillis: Long = INITIAL_DELAY_MILLIS,
    maxDelayMillis: Long = MAX_DELAY_MILLIS,
    factor: Double = DELAY_FACTOR,
    block: suspend () -> T
): T {
    var currentDelay = initialDelayMillis

    repeat(times) {
        try { return block() } catch (ignore: Exception) { }

        delay(currentDelay)
        currentDelay = (currentDelay * factor).toLong().coerceAtMost(maxDelayMillis)
    }

    return block() // last attempt
}