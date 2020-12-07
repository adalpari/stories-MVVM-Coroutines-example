package com.adalpari.storiesexample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhoto(val id: String, val description: String, val urls: Urls): Parcelable