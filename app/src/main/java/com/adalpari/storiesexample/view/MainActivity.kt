package com.adalpari.storiesexample.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adalpari.storiesexample.R
import com.adalpari.storiesexample.adapter.ThumbnailsAdapter
import com.adalpari.storiesexample.model.StoriesSet
import com.adalpari.storiesexample.presenter.MainActivityPresenter
import com.adalpari.storiesexample.usecase.GetStoriesUseCase

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    private val getStoriesUseCase: GetStoriesUseCase = GetStoriesUseCase()
    private val mainActivityPresenter: MainActivityPresenter = MainActivityPresenter(getStoriesUseCase)

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        val view = super.onCreateView(parent, name, context, attrs)

        recyclerView = findViewById(R.id.thumbnails_recycler_view)

        mainActivityPresenter.onAttach(this)
        mainActivityPresenter.init()

        return view
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
        val adapter = ThumbnailsAdapter(entries)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }
}