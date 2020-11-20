package com.adalpari.storiesview.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.adalpari.storiesview.R
import com.adalpari.storiesview.model.StoriesSet
import com.adalpari.storiesview.view.StoryDetailActivity
import com.squareup.picasso.Picasso


class ThumbnailsAdapter constructor(
    private val entries: List<StoriesSet>,
    private val activity: Activity
): RecyclerView.Adapter<ThumbnailsAdapter.ThumbnailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder =
        ThumbnailViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_thumbnail,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        val storiesSet = entries[position]
        Picasso.get()
            .load(storiesSet.stories[0].contentUrl)
            .resize(64, 64)
            .centerCrop()
            .into(holder.imageView)
        holder.thumbnailStroke.visibility = when (storiesSet.isViewed()) {
            true -> View.INVISIBLE
            false -> View.VISIBLE
        }
        holder.imageView.setOnClickListener {
            val intent = Intent(activity, StoryDetailActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, holder.imageView, "story_image")
            activity.startActivity(intent, options.toBundle())
        }
    }

    override fun getItemCount(): Int = entries.size

    class ThumbnailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.story_thumbnail)
        var thumbnailStroke: ImageView = view.findViewById(R.id.thumbnail_stroke)
    }
}