package com.adalpari.storiesexample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B: ViewBinding,VM: ViewModel> : AppCompatActivity() {

    lateinit var binding: B
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)

        onObserve()
    }

    abstract fun onObserve()

    abstract fun getViewBinding(): B
}
