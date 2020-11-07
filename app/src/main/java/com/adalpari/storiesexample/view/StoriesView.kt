package com.adalpari.storiesexample.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adalpari.storiesexample.R
import com.adalpari.storiesexample.adapter.ThumbnailsAdapter
import com.adalpari.storiesexample.model.StoriesSet

class StoriesView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        inflate(context, R.layout.view_stories, this)
    }

    fun showStories(entries: List<StoriesSet>) {
        val recyclerView: RecyclerView = findViewById(R.id.thumbnails_recycler_view)
        val adapter = ThumbnailsAdapter(entries)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

}