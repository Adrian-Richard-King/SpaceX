package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LaunchFailureDetailsDTO(
    var time: Int = 0,
    var altitude: Double? = null,
    var reason: String? = null
) : Parcelable