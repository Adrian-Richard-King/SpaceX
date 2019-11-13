package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class SpaceXModel(
    var flight_number: Int? = null,
    var mission_name: String? = null,
    var upcoming: Boolean? = null,
    var launch_year: String? = null,
    var launch_date_unix: Int? = null,
    var launch_date_utc: String? = null,
    var launch_date_local: String? = null,
    var is_tentative: Boolean? = null,
    var tentative_max_precision: String? = null,
    var tbd: Boolean? = null,
    var launch_window: Int? = null,
    var rocket: RocketDTO? = null,
    var telemetry: TelemetryDTO? = null,
    var launch_site: LaunchSiteDTO? = null,
    var launch_success: Boolean? = null,
    var launch_failure_details: LaunchFailureDetailsDTO? = null,
    var links: LinksDTO? = null,
    var details: String? = null,
    var static_fire_date_utc: String? = null,
    var static_fire_date_unix: Int? = null,
    var timeline: TimelineDTO? = null,
    var crew: @RawValue Any? = null,
    var mission_id: List<String>? = null,
    var ships: List<String>? = null
) : Parcelable