
package com.androidapps.murad.nearby.repository

import androidx.lifecycle.LiveData
//import com.androidapps.murad.nearby.api.ApiRetrofitBuilder
import com.androidapps.murad.nearby.api.NetworkMapper
import com.androidapps.murad.nearby.api.utils.AppConstants
import com.androidapps.murad.nearby.data.VenueDataMapper
import com.androidapps.murad.nearby.models.VenueData
import com.androidapps.murad.nearby.data.dao.VenueDao
import com.androidapps.murad.nearby.di.VenueRetrofit
import com.androidapps.murad.nearby.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class VenueRepository
constructor(
    private val venueDao: VenueDao,
    private val venueRetrofit: VenueRetrofit,
    private val networkMapper: NetworkMapper,
    private val venueDataMapper: VenueDataMapper
) {
    suspend fun getVenue(): Flow<DataState<List<VenueData>>> = flow {
        emit(DataState.Loading)
        try {
            val networkVenues = venueRetrofit.getPlaces(latLng = "65.01236,25.46816",clientId = AppConstants.CLIENT_ID,clientSecret = AppConstants.CLIENT_SECRET ,query = "food")
            val venues = networkMapper.mapFromEntityList(networkVenues)
            for(venue in venues){
                venueDao.insert(venueDataMapper.mapToEntity(venue))
            }
            val cachedVenues = venueDao.readData()
            emit(DataState.Success(venueDataMapper.mapFromEntityList(cachedVenues)))
        } catch (e: Exception) {
            emit(DataState.Error(e))

        }

    }
  /*  suspend fun getVenue(): Flow<DataState<List<VenueData>>> = flow {
        emit(DataState.Loading)
        try {
            val networkVenues = venueRetrofit.getVenue()
            val venues = networkMapper.mapFromEntityList(networkVenues)
            for(venue in venues){
                venueDao.insert(venueDataMapper.mapToEntity(venue))
            }
            val cachedVenues = venueDao.readData()
            emit(DataState.Success(venueDataMapper.mapFromEntityList(cachedVenues)))
        } catch (e: Exception) {
            emit(DataState.Error(e))

        }

    }*/
}






/*
class VenueRepository(private val _venueDao: VenueDao) {

    val readAllData: LiveData<List<VenueData>> = _venueDao.readData()

    suspend fun addVenue(venueData: VenueData){
        _venueDao.insertAll(venueData)
    }

    suspend fun getNearPlaces(latLng: String, clientId: String, clientSecret: String, query: String): Response<List<VenueData>> {
        return ApiRetrofitBuilder.apiService.getPlaces(latLng, clientId, clientSecret, query)
    }

}*/
