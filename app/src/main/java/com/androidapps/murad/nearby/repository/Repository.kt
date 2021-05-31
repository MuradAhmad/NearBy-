package com.androidapps.murad.nearby.repository

import com.androidapps.murad.nearby.api.MyRetrofitBuilder
import com.androidapps.murad.nearby.models.VenueData
import kotlinx.coroutines.CompletableJob
import retrofit2.Response

class Repository {

    var job: CompletableJob? = null
    suspend fun getNearPlaces(latLng: String, clientId: String, clientSecret: String, query: String): Response<List<VenueData>> {
        return MyRetrofitBuilder.apiService.getPlaces(latLng, clientId, clientSecret, query)
    }

    fun cancelJobs(){
        job?.cancel()
    }
}