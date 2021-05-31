package com.androidapps.murad.nearby.repository

import androidx.lifecycle.LiveData
import com.androidapps.murad.nearby.api.MyRetrofitBuilder
import com.androidapps.murad.nearby.models.VenueData
import com.androidapps.murad.nearby.data.dao.VenueDao
import retrofit2.Response

class VenueRepository(private val _venueDao: VenueDao) {

    val readAllData: LiveData<List<VenueData>> = _venueDao.readData()

    suspend fun addVenue(venueData: VenueData){
        _venueDao.insertAll(venueData)
    }

}