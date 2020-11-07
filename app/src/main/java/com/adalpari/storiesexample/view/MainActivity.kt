package com.adalpari.storiesexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adalpari.storiesexample.R
import com.adalpari.storiesexample.model.StoriesSet
import com.adalpari.storiesexample.presenter.MainActivityPresenter
import com.adalpari.storiesexample.usecase.GetStoriesUseCase

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    private val getStoriesUseCase: GetStoriesUseCase = GetStoriesUseCase()
    private val mainActivityPresenter: MainActivityPresenter = MainActivityPresenter(getStoriesUseCase)

    private lateinit var storiesView: StoriesView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        storiesView = findViewById(R.id.stories_view)

        mainActivityPresenter.onAttach(this)
        mainActivityPresenter.init()
    }

    override fun onResume() {
        super.onResume()
        mainActivityPresenter.onAttach(this)
    }

    override fun onPause() {
        mainActivityPresenter.onDetach()
        super.onPause()
    }

    override fun showStories(entries: List<StoriesSet>) {
        storiesView.showStories(entries)
    }
}