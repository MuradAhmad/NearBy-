package com.androidapps.murad.nearby.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidapps.murad.nearby.models.VenueData
import com.androidapps.murad.nearby.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MyViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<List<VenueData>>> = MutableLiveData()

    suspend fun getPost(latLng: String, clientId: String, clientSecret: String, query: String){
        viewModelScope.launch {
            val response:Response<List<VenueData>> = repository.getNearPlaces(latLng, clientId, clientSecret, query)
            myResponse.value = response
        }
    }


    /*fun addVenue(venueData: VenueData){
        viewModelScope.launch (Dispatchers.IO){
            _venueRepository.addVenue(venueData)
        }
    }*/

}