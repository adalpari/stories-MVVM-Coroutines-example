package com.adalpari.storiesexample.view

import android.os.Bundle
import com.adalpari.storiesexample.R
import com.adalpari.storiesexample.databinding.ActivityMainBinding
import com.adalpari.storiesview.model.StoriesSet
import com.adalpari.storiesexample.presenter.MainActivityPresenter
import com.adalpari.storiesexample.usecase.GetStoriesUseCase

class MainActivity : BaseActivity(), MainActivityPresenter.View {

    private val getStoriesUseCase: GetStoriesUseCase = GetStoriesUseCase()
    private val mainActivityPresenter: MainActivityPresenter = MainActivityPresenter(getStoriesUseCase)

    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
        }

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
        binding.storiesView.showStories(entries, this)
    }
}