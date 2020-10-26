package com.adalpari.storiesexample.usecase

interface UseCase<I, O> {
    fun execute(request: Request<I>, callback: Callback<O>)
    interface Callback<O> {
        fun onResponse(response: Response<O>)
    }
}