package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RocketDTO(
    var rocket_id: String? = null,
    var rocket_name: String? = null,
    var rocket_type: String? = null,
    var first_stage: FirstStageDTO? = null,
    var second_stage: SecondStageDTO? = null,
    var fairings: FairingsDTO? = null
) : Parcelable