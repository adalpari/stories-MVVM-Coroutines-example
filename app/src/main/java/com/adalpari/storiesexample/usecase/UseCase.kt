package com.adalpari.storiesexample.usecase

interface UseCase<I, O> {
    fun execute(input: I, callback: Callback<O>)
    interface Callback<O> {
        fun onResponse(output: O)
    }
}