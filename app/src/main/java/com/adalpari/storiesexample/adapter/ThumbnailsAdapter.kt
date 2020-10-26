package com.adalpari.storiesexample.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.adalpari.storiesexample.model.StoriesSet

class ThumbnailsAdapter constructor(private val entries: List<StoriesSet>): RecyclerView.Adapter<ThumbnailsAdapter.ThumbnailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder {
        TODO("not implemented")
    }

    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        TODO("not implemented")
    }

    override fun getItemCount(): Int = entries.size

    class ThumbnailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: SimpleDraweeView = view.findViewById(R.id.file_image)
        var thumbnailStroke: ImageView = view.findViewById(R.id.thumbnail_stroke)
    }
}