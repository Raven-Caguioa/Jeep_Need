package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentHomeBinding
import com.example.jeep_need.databinding.FragmentProfileBinding

class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.ivDriver.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_driverList)
        }
        binding.ivRoute.setOnClickListener{
            findNavController().navigate(R.id.action_home_to_routes)
        }
        binding.ivMap.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_map)
        }
        return binding.root
    }

}