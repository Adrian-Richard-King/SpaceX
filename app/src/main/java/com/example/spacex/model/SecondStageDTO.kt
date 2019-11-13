package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SecondStageDTO(
    var block: Double? = null,
    var payloads: List<PayloadsDTO>? = null
) : Parcelable