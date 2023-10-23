package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentProfileBinding
import com.example.jeep_need.databinding.FragmentRoutesBinding

class Routes : Fragment() {
    private lateinit var binding: FragmentRoutesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRoutesBinding.inflate(inflater, container, false)

        binding.btBack.setOnClickListener {
            findNavController().navigate(R.id.action_routes_to_home)
        }
        binding.tvEarth.setOnClickListener {
            Toast.makeText(requireActivity(), "No Available Drivers", Toast.LENGTH_SHORT).show()
        }
        binding.tvHouse.setOnClickListener {
            Toast.makeText(requireActivity(), "No you Don't", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}