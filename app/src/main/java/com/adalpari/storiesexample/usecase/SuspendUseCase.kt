package com.adalpari.storiesexample.usecase

interface SuspendUseCase<I, O> {

    suspend fun call(input: I): O

}