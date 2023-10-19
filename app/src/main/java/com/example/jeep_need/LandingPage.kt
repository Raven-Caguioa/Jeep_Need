package com.example.jeep_need

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentLandingPageBinding

class LandingPage : Fragment() {

    private lateinit var binding: FragmentLandingPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLandingPageBinding.inflate(inflater, container, false)
        binding.letGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_landingPage_to_login)
        }
        return binding.root
    }


}