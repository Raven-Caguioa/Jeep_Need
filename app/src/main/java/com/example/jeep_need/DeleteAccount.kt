package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentDeleteAccountBinding
import com.example.jeep_need.databinding.FragmentProfileBinding

class DeleteAccount : Fragment() {
    private lateinit var binding: FragmentDeleteAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeleteAccountBinding.inflate(inflater, container, false)

        binding.btConfirm.setOnClickListener {
            findNavController().navigate(R.id.action_deleteAccount_to_landingPage)
        }
        binding.btCancel.setOnClickListener{
            findNavController().navigate(R.id.action_deleteAccount_to_profile)
        }
        return binding.root
    }

}