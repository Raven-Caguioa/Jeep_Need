package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentAboutUsBinding
import com.example.jeep_need.databinding.FragmentLoginBinding

class AboutUs : Fragment() {
    private lateinit var binding: FragmentAboutUsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAboutUsBinding.inflate(inflater,container,false)

        binding.btRethorn.setOnClickListener {
            findNavController().navigate(R.id.action_aboutUs_to_profile)
        }
        return binding.root

    }
}