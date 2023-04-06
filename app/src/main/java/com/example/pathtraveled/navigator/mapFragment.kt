package com.example.pathtraveled.navigator

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pathtraveled.R
import com.example.pathtraveled.databinding.FragmentMainBinding
import com.example.pathtraveled.databinding.FragmentMapBinding
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class mapFragment : Fragment() {
    lateinit var mapView: MapView
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("42e44466-37c8-44db-bf8e-b8862599cc8f")
        MapKitFactory.initialize(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        mapView = binding.mapview
        mapView.map.move(CameraPosition(Point(47.0,39.0),11.0f,0.0f,0.0f))

        return binding.root
    }

    override fun onStart() {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}