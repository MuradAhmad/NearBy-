package com.androidapps.murad.nearby.userlocation

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.androidapps.murad.nearby.api.utils.AppConstants
import com.androidapps.murad.nearby.utils.AppPermissions

class UserLocation: AppCompatActivity() {
    private lateinit var _locationManager: LocationManager

    private lateinit var _latlng: String

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
                            _latlng = ""+location.latitude + "," + location.longitude
                            Log.d("Location:", " Success Location Data feeds")
                            Log.d("Location:", _latlng)
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


}