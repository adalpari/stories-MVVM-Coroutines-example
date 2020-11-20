package com.adalpari.storiesview.view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adalpari.storiesview.R
import com.adalpari.storiesview.adapter.ThumbnailsAdapter
import com.adalpari.storiesview.model.StoriesSet

class StoriesView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        inflate(context, R.layout.view_stories, this)
    }

    fun showStories(entries: List<StoriesSet>, activity: Activity) {
        val recyclerView: RecyclerView = findViewById(R.id.thumbnails_recycler_view)
        val adapter = ThumbnailsAdapter(entries, activity)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

}