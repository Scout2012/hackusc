package com.example.hackusc

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.GoogleMap

class NearbyAngels : FragmentActivity(), MapFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {
        Log.i(TAG, "onFragmentInteraction!")

    }

    private lateinit var mMap: GoogleMap
    private var TAG = "NearbyAngels"

    override fun onCreate(savedInstanceState: Bundle?){
        Log.i(TAG, "Hi!")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nearby_angels_activity)
    }

}
