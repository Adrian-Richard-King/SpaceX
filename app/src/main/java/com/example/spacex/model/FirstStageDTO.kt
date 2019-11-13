package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FirstStageDTO(
    var cores: List<CoresDTO>? = null
) : Parcelable