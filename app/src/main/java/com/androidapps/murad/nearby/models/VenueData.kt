package com.androidapps.murad.nearby.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venue_table")
data class VenueData(
    var placeName: String,
    var placeAddress: String,
    var placeDistance: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}