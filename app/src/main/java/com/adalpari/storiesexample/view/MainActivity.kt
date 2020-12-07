package com.adalpari.storiesexample.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.adalpari.storiesexample.R
import com.adalpari.storiesexample.databinding.ActivityMainBinding
import com.adalpari.storiesexample.viewmodel.GetStoriesViewModel
import com.adalpari.storiesexample.viewmodel.UiState

class MainActivity : BaseActivity() {

    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private val viewModel: GetStoriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
        }

        viewModel.uiState().observe(this, { uiState -> showStories(uiState) })
        viewModel.getStories()
    }

    private fun showStories(uiState: UiState) {
        when (uiState) {
            is UiState.Success -> {
                binding.progressBar.visibility = View.GONE
                binding.storiesView.showStories(uiState.entries, this)
            }

            is UiState.Loading ->  binding.progressBar.visibility = View.VISIBLE

            is UiState.Error -> {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this, uiState.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
