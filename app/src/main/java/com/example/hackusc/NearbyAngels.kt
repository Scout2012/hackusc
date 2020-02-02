package com.example.hackusc

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task

class NearbyAngels : FragmentActivity(), MapFragment.OnFragmentInteractionListener{

    private lateinit var mMap: GoogleMap
    private var TAG = "NearbyAngels"
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?){
        Log.i(TAG, "Hi!")
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        setContentView(R.layout.nearby_angels_activity)
    }

    public override fun onStart() {
        super.onStart()
        getDeviceLocation()
    }

    private fun getDeviceLocation() {
        /*
     * Get the best and most recent location of the device, which may be null in rare
     * cases when a location is not available.                            )

     */
        try {
            if (true) {
                val locationResult = fusedLocationClient.getLastLocation()
                locationResult.addOnCompleteListener(this){ task ->
                    if(task.isSuccessful && task.result != null){
                        Log.i(TAG, "Your location is " + task.result)
                    } else {
                        Log.e(TAG, "Couldn't get most recent location")
                    }
                }
            }
        } catch (e: SecurityException) {
            Log.e("Exception: %s", e.message)
        }

    }

    override fun onFragmentInteraction(uri: Uri) {
        Log.i(TAG, "onFragmentInteraction!")
    }

}
