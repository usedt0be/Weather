package com.example.weather.presentation.location

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.weather.presentation.viewmodel.HomeViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import java.util.Locale
import javax.inject.Inject


private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
private lateinit var geocoder: Geocoder



class LocationClient @Inject constructor(
    private val context: Activity,
    private val homeViewModel: HomeViewModel
) {
    private val fusedLocationProviderClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(context)
    }


    init {
        checkPermissions()
    }

    fun request(){
        ActivityCompat.requestPermissions(
            context, arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ), 1
        )
    }




    @Suppress("DEPRECATION")
    fun Geocoder.getAddress(
        latitude: Double, longitude: Double, address: (Address?) -> Unit
    ) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getFromLocation(latitude, longitude, 1) { address(it.firstOrNull()) }
            return
        }

        try {
            address(getFromLocation(latitude, longitude, 1)?.firstOrNull())
        } catch (e: Exception) {
            //will catch if there is an internet problem
            address(null)
        }
    }

    fun checkPermissions() {
        if (ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            getLocation()

        } else {
            ActivityCompat.requestPermissions(
                context, arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ), 1
            )
            checkPermissions()
        }

    }


//     fun CheckForPermissions() {
//
//
//
//
//        if (ActivityCompat.checkSelfPermission(
//                context, Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                context, Manifest.permission.ACCESS_COARSE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED
//        )  {
//            getLocation()
//            Log.d("MAIN_LOC", "GRANTED")
////            onPermissionGranted()
////            onPermissionGranted:  () -> Unit,onPermissionDenied: () -> Unit
//            Toast.makeText(context, "granted!",Toast.LENGTH_SHORT)
//
//
//
//        } else if(ActivityCompat.checkSelfPermission(
//                context, Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_DENIED && ActivityCompat.checkSelfPermission(
//                context, Manifest.permission.ACCESS_COARSE_LOCATION
//            ) == PackageManager.PERMISSION_DENIED
//        ) {
//            Log.d("MAIN_LOC", "DENIED")
//            Toast.makeText(context, "dinied",Toast.LENGTH_SHORT)
////            onPermissionDenied()
//        }
//
//    }




    @SuppressLint("MissingPermission")
    fun getLocation() {
        geocoder = Geocoder(context, Locale.getDefault())

        fusedLocationProviderClient.getCurrentLocation(
            Priority.PRIORITY_HIGH_ACCURACY, CancellationTokenSource().token

        ).addOnSuccessListener {
            if (it == null) {
                Toast.makeText(context, "Can't get location", Toast.LENGTH_SHORT).show()
            } else {
                homeViewModel.getHourlyWeatherByLocation(lat = it.latitude, lon = it.longitude)

                homeViewModel.getWeatherResultByLocation(lat = it.latitude, lon = it.longitude)

                Log.d("LOCTAG", "getLastLocation : ${it.latitude}")

                Geocoder(context, Locale.getDefault()).getAddress(
                    it.latitude,
                    it.longitude
                ) { address ->

                    try {
                        if (address != null) {
                            homeViewModel.getAddress(city = address.locality)
                        }

                    } catch (e: Exception) {
                        error(message = "Can't get address")
                    }
                    Log.d("LOCTAG", "getLastLocation : $address")

                }
            }
        }
    }


}






