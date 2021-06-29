package com.androidapps.murad.nearby.di

import com.androidapps.murad.nearby.api.NetworkMapper
import com.androidapps.murad.nearby.data.VenueDataMapper
import com.androidapps.murad.nearby.data.dao.VenueDao
import com.androidapps.murad.nearby.repository.VenueRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideVenueRepository(
        venueDao: VenueDao,
        venueRetrofit: VenueRetrofit,
        venueDataMapper: VenueDataMapper,
        networkMapper: NetworkMapper
    ): VenueRepository {
        return VenueRepository(venueDao, venueRetrofit, networkMapper, venueDataMapper)
    }
}

