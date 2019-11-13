package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TelemetryDTO(
    var flight_club: String? = null
) : Parcelable