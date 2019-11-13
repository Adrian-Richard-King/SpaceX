package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TimelineDTO(
    var webcast_liftoff: Int = 0
) : Parcelable