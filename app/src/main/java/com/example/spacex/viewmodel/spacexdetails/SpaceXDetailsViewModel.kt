package com.example.spacex.viewmodel.spacexdetails

import com.example.spacex.model.SpaceXModel
import com.example.spacex.util.Utils.dateFormatYYYYMMDD
import com.example.spacex.util.formatTo
import com.example.spacex.util.toDate
import com.example.spacex.viewmodel.CustomViewModel

class SpaceXDetailsViewModel : CustomViewModel() {

    var selectedData: SpaceXModel? = null

    val formattedDate: String
        get() = selectedData?.launch_date_utc?.toDate()?.formatTo(dateFormatYYYYMMDD) ?: ""

}