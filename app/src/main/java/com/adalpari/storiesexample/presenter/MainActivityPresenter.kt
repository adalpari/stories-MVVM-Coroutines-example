package com.adalpari.storiesexample.presenter

import com.adalpari.storiesview.model.StoriesSet
import com.adalpari.storiesexample.usecase.GetStoriesUseCase
import com.adalpari.storiesexample.usecase.UseCase

class MainActivityPresenter constructor(private val getStoriesUseCase: GetStoriesUseCase) {

    private var view: View? = null

    fun onAttach(view: View) {
        this.view = view
    }

    fun onDetach() {
        this.view = null
    }

    fun init() {
        // NOTE: this has been simplified to focus in the stories example.
        // but it has to be done with thread handling instead of a direct call
        getStoriesUseCase.execute(GetStoriesUseCase.Input(), object: UseCase.Callback<GetStoriesUseCase.Output> {
            override fun onResponse(output: GetStoriesUseCase.Output) {
                view?.showStories(output.entries)
            }
        })
    }

    interface View {
        fun showStories(entries: List<com.adalpari.storiesview.model.StoriesSet>)
    }
}