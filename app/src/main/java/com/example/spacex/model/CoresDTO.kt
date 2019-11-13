package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CoresDTO(
    var core_serial: String? = null,
    var flight: Int = 0,
    var block: Int = 0,
    var gridfins: Boolean? = null,
    var legs: Boolean? = null,
    var reused: Boolean? = null,
    var land_success: Boolean? = null,
    var landing_intent: Boolean? = null,
    var landing_type: String? = null,
    var landing_vehicle: String? = null
) : Parcelable