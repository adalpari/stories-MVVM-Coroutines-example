package com.adalpari.storiesexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.adalpari.storiesexample.R
import com.adalpari.storiesexample.model.StoriesSet
import com.squareup.picasso.Picasso

class ThumbnailsAdapter constructor(private val entries: List<StoriesSet>): RecyclerView.Adapter<ThumbnailsAdapter.ThumbnailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder =
        ThumbnailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_thumbnail, parent, false))

    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        val storiesSet = entries[position]
        Picasso.get()
            .load(storiesSet.stories[0].contentUrl)
            .centerCrop()
            .into(holder.imageView)
        holder.thumbnailStroke.visibility = when (storiesSet.isViewed) {
            true -> View.VISIBLE
            false -> View.INVISIBLE
        }
    }

    override fun getItemCount(): Int = entries.size

    class ThumbnailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.thumbnail_image)
        var thumbnailStroke: ImageView = view.findViewById(R.id.thumbnail_stroke)
    }
}