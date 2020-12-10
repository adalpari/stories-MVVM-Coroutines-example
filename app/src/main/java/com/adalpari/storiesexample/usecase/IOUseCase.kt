package com.adalpari.storiesexample.usecase

interface IOUseCase<I, O> {

    suspend fun call(input: I): O

}