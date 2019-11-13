package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PayloadsDTO(
    var payload_id: String? = null,
    var isReused: Boolean = false,
    var nationality: String? = null,
    var manufacturer: String? = null,
    var payload_type: String? = null,
    var payload_mass_kg: Double? = null,
    var payload_mass_lbs: Double? = null,
    var orbit: String? = null,
    var orbit_params: OrbitParamsDTO? = null,
    var norad_id: List<Int>? = null,
    var customers: List<String>? = null
) : Parcelable