package com.adalpari.storiesexample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Urls(val regular: String, val thumb: String): Parcelable