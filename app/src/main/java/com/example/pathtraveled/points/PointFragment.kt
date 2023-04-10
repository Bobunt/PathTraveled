package com.example.pathtraveled.points

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pathtraveled.R
import com.example.pathtraveled.databinding.FragmentPointBinding

class PointFragment : Fragment() {
    private var _binding: FragmentPointBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_point, container, false)
    }
}