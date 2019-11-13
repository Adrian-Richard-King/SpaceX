package com.example.spacex.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LinksDTO(
    var mission_patch: String? = null,
    var mission_patch_small: String? = null,
    var reddit_campaign: String? = null,
    var reddit_launch: String? = null,
    var reddit_recovery: String? = null,
    var reddit_media: String? = null,
    var presskit: String? = null,
    var article_link: String? = null,
    var wikipedia: String? = null,
    var video_link: String? = null,
    var youtube_id: String? = null,
    var flickr_images: List<String>? = null
) : Parcelable