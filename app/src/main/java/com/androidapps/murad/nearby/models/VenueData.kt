package com.androidapps.murad.nearby.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class VenueData(
    var placeName: String,
    var placeAddress: String,
    var placeDistance: Int
)