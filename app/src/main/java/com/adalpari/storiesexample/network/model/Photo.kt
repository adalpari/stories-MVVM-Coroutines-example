package com.adalpari.storiesexample.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(val id: String, val description: String, val urls: Urls): Parcelable