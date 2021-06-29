package com.androidapps.murad.nearby.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venue_table")
data class VenueDataEntity(

   /* @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 1,*/

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "distance")
    var distance: Int
) {

}