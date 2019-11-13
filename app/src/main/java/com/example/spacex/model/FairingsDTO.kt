package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FairingsDTO(
    var isReused: Boolean = false,
    var isRecovery_attempt: Boolean = false,
    var isRecovered: Boolean = false,
    var ship: String? = null
) : Parcelable