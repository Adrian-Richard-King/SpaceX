package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LaunchSiteDTO(
    var site_id: String? = null,
    var site_name: String? = null,
    var site_name_long: String? = null
) : Parcelable