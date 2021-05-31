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
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.androidapps.murad.nearby.adapters.RecyclerAdapter
import com.androidapps.murad.nearby.api.utils.AppConstants
import com.androidapps.murad.nearby.repository.Repository
import com.androidapps.murad.nearby.utils.AppPermissions
import com.androidapps.murad.nearby.viewmodel.MyViewModel
import com.androidapps.murad.nearby.viewmodel.MyViewModelFactory
import com.androidapps.murad.nearby.viewmodel.VenueViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener{

    private lateinit var _locationManager: LocationManager

    lateinit var latlng: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //getLocation()
        //SearchVenuesRequest
        //showData()


    }

    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.layout.main_menu,menu)

        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)

        return true

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null){
            //searchVenues(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            //searchVenues(query)
        }
        return true
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {

        // checking location permission
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // request permission
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1234);
            return
        }
        _locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (AppPermissions.isLocationEnabled(this)) {

            _locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                10000,
                5F,
                object : LocationListener {
                    override fun onLocationChanged(location: Location) {
                        if (location != null) {
                            latlng = ""+location.latitude + "," + location.longitude
                            Log.d("Location:", " Success Location Data feeds")
                            Log.d("Location:", latlng)
                        } else {
                            Log.d("Location:", "Failed Location Data feeds")
                        }

                    }
                })

        }
        else {
            Log.d("Location:", "Permissions missing")
        }
    }




    /* override fun onDestroy() {
         super.onDestroy()
         viewModel.cancelJobs()
     }*/
}




