package com.androidapps.murad.nearby.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androidapps.murad.nearby.data.VenueDataEntity
import com.androidapps.murad.nearby.models.VenueData

@Dao
interface VenueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(venueDataEntity: VenueDataEntity): Long

    @Query("SELECT * FROM venue_table")
    suspend fun readData(): List<VenueDataEntity>

}