package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentSignupChoiceBinding

class Signup_choice : Fragment() {
    private lateinit var binding: FragmentSignupChoiceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupChoiceBinding.inflate(inflater, container, false)

        binding.btDriver.setOnClickListener {
            findNavController().navigate(R.id.action_signup_choice_to_signup_Driver)
        }
        binding.btPassenger.setOnClickListener {
            findNavController().navigate(R.id.action_signup_choice_to_signup_Passenger)
        }
        return binding.root
    }
}