package com.androidapps.murad.nearby.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androidapps.murad.nearby.models.VenueData

@Dao
interface VenueDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg venueData: VenueData)

    @Query("SELECT placeName FROM venue_table ORDER BY id DESC")
    fun readData(): LiveData<List<VenueData>>

}