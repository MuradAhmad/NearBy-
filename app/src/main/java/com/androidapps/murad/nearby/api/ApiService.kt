package com.androidapps.murad.nearby.api

import com.androidapps.murad.nearby.models.VenueData
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/v2/venues/explore")
    suspend fun getPlaces(
        @Query("ll") latLng: String,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("query") query: String,
    ): Response<List<VenueData>>

    /*  suspend fun getPlaces(
      @Header("ll") latLng: String,
      @Header("client_id") clientId: String,
      @Header("client_secret") clientSecret: String,
      @Header("query") query: String,
  ): Response<List<VenueData>>*/

}