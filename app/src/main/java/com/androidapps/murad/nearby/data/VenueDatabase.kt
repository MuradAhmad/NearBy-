package com.androidapps.murad.nearby.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidapps.murad.nearby.data.dao.VenueDao
import com.androidapps.murad.nearby.models.VenueData

@Database(
    entities = [VenueDataEntity::class],
    version = 1,
    exportSchema = false
)

abstract class VenueDatabase: RoomDatabase() {
    abstract fun venueDao(): VenueDao

    companion object {
        @Volatile
        private var INSTANCE: VenueDatabase? = null

        val DATABASE_NAME: String = "venue_database"

    }
}