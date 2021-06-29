package com.androidapps.murad.nearby.viewmodel

import android.app.Application
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.androidapps.murad.nearby.models.VenueData
import com.androidapps.murad.nearby.data.VenueDatabase
import com.androidapps.murad.nearby.repository.VenueRepository
import com.androidapps.murad.nearby.utils.DataState



import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


class VenueViewModel
@ViewModelInject
constructor(
    private val venueRepository: VenueRepository,
    @Assisted
    private val savedStateHandle: SavedStateHandle

): ViewModel()
{
    private val _dataState: MutableLiveData<DataState<List<VenueData>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<VenueData>>>
    get () = _dataState

    fun  setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetVenueEvents -> {
                    venueRepository.getVenue()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None -> {
                    // No events
                }
            }
        }
    }
}

sealed class MainStateEvent{

    object GetVenueEvents: MainStateEvent()

    object None: MainStateEvent()
}