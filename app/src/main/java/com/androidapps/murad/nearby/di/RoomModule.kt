package com.androidapps.murad.nearby.di

import android.content.Context
import androidx.room.Room
import com.androidapps.murad.nearby.BaseApplication
import com.androidapps.murad.nearby.data.VenueDatabase
import com.androidapps.murad.nearby.data.dao.VenueDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideVenueDb(@ApplicationContext context: Context) : VenueDatabase {
        return Room.databaseBuilder(
            context,
            VenueDatabase::class.java,
            VenueDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideVenueDao(venueDatabase: VenueDatabase): VenueDao {
        return venueDatabase.venueDao()
    }

}