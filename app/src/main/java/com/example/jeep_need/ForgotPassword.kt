package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentForgotPasswordBinding
import com.example.jeep_need.databinding.FragmentLoginBinding

class ForgotPassword : Fragment() {
    private lateinit var binding: FragmentForgotPasswordBinding
    private lateinit var btSignin : ImageView
    private lateinit var tvSignUp : ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(inflater,container,false)

        binding.btReturn.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPassword_to_login_nav)
        }
        binding.btUpdatePass.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPassword_to_login_nav)
        }

        return binding.root

    }
}