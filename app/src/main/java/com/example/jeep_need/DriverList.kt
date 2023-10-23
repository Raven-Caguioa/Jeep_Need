package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentDriverListBinding
import com.example.jeep_need.databinding.FragmentProfileBinding

class DriverList : Fragment() {

    private lateinit var binding: FragmentDriverListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDriverListBinding.inflate(inflater, container, false)

        binding.btRethrone2.setOnClickListener {
            findNavController().navigate(R.id.action_driverList_to_home)
        }
        binding.btBack2.setOnClickListener {
            findNavController().navigate(R.id.action_driverList_to_routes)

        }
        return binding.root
    }
}