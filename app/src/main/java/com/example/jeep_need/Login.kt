package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentLoginBinding


class Login : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)

        binding.btSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_home)
        }
        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signup_choice)
        }
        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_login_nav_to_forgotPassword)
        }

        return binding.root

    }
}