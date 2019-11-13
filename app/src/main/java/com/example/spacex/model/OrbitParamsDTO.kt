package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrbitParamsDTO(
    var reference_system: String? = null,
    var regime: String? = null,
    var longitude: Double? = null,
    var semi_major_axis_km: Double? = null,
    var eccentricity: Double? = null,
    var periapsis_km: Double? = null,
    var apoapsis_km: Double? = null,
    var inclination_deg: Double? = null,
    var period_min: Double? = null,
    var lifespan_years: Double? = null,
    var epoch: String? = null,
    var mean_motion: Double? = null,
    var raan: Double? = null,
    var arg_of_pericenter: Double? = null,
    var mean_anomaly: Double? = null
) : Parcelable