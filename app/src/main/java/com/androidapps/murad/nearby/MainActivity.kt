package com.androidapps.murad.nearby

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.Display
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidapps.murad.nearby.api.utils.AppConstants
import com.androidapps.murad.nearby.models.VenueData

import com.androidapps.murad.nearby.utils.AppPermissions
import com.androidapps.murad.nearby.utils.DataState
import com.androidapps.murad.nearby.viewmodel.MainStateEvent

import com.androidapps.murad.nearby.viewmodel.VenueViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: VenueViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeObserver()
        viewModel.setStateEvent(MainStateEvent.GetVenueEvents)

    }


    private fun subscribeObserver() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when(dataState) {
                is DataState.Success<List<VenueData>> -> {
                    appendVenueTitles(dataState.data)
                }
                is DataState.Error -> {
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?) {
        if(message != null) {
            Log.d("Message: ", message)
        } else {
            Log.d("Error: ", "Unknown Error")
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        if(isDisplayed) {
            Log.d("Loading: ", "Loading .....")
        }
    }

    private fun appendVenueTitles(venueData: List<VenueData>){
        val sb = StringBuilder()
        for(venue in venueData){
           sb.append(venue.placeName + "\n")
        }
        Log.d("Name: ", sb.toString())
    }

}

