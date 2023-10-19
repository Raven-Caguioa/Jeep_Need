package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentSignupDriverBinding
import com.example.jeep_need.databinding.FragmentSignupPassengerBinding

class Signup_Passenger : Fragment() {
    private lateinit var binding: FragmentSignupPassengerBinding
    private lateinit var tvSignIn : TextView
    private lateinit var btPassenger : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupPassengerBinding.inflate(inflater, container, false)

        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signup_Passenger_to_login)
        }
        return binding.root
    }
}