package com.androidapps.murad.nearby.di

import com.androidapps.murad.nearby.api.VenueNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Header

interface VenueRetrofit{

    @GET("explore")
    suspend fun getVenue(): List<VenueNetworkEntity>

    @GET("/v2/venues/explore")
    suspend fun getPlaces(
        @Header("ll") latLng: String,
        @Header("client_id") clientId: String,
        @Header("client_secret") clientSecret: String,
        @Header("query") query: String,
    ): List<VenueNetworkEntity>
}