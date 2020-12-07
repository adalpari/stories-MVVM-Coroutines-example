package com.adalpari.storiesexample.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Urls(val regular: String, val thumb: String): Parcelable