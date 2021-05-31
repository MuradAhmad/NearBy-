package com.androidapps.murad.nearby.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.androidapps.murad.nearby.models.VenueData
import com.androidapps.murad.nearby.data.VenueDatabase
import com.androidapps.murad.nearby.repository.VenueRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VenueViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<VenueData>>
    private val _venueRepository: VenueRepository

    init {
        val venueDao = VenueDatabase.getDatabase(application).venueDao()
        _venueRepository = VenueRepository(venueDao)
        readAllData = _venueRepository.readAllData
    }




}