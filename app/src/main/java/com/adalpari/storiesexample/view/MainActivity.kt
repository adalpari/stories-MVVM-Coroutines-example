package com.adalpari.storiesexample.view

import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.adalpari.storiesexample.databinding.ActivityMainBinding
import com.adalpari.storiesexample.viewmodel.GetStoriesViewModel
import com.adalpari.storiesexample.viewmodel.StoriesState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, GetStoriesViewModel>() {

    override val viewModel: GetStoriesViewModel by viewModels()

    override fun onObserve() {
        viewModel.uiState().observe(this, { uiState -> showStories(uiState) })
        viewModel.getStories()
    }

    private fun showStories(storiesState: StoriesState) {
        when (storiesState) {
            is StoriesState.Success -> {
                binding.progressBar.visibility = View.GONE
                binding.storiesView.showStories(storiesState.entries, this)
            }

            is StoriesState.Loading ->  binding.progressBar.visibility = View.VISIBLE

            is StoriesState.Error -> {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this, storiesState.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}