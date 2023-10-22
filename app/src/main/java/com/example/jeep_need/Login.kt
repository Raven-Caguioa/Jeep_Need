package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentLoginBinding


class Login : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var btSignin : ImageView
    private lateinit var tvSignUp : ImageView
    //private lateinit var btSignin2 : ImageView

    private lateinit var db: SQLiteOpenHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        db = SQLiteOpenHelper(requireActivity())
        binding.btSignIn.setOnClickListener {
            val email = binding.usernameSignIn.text.toString()
            val password = binding.passwordSignIn.text.toString()
            logindriver(email, password)

        }
        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signup_choice)


        }
        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_login_nav_to_forgotPassword)
        }


        return binding.root

    }
    private fun logindriver(email: String, password: String) {


        if (ValidationUtils.isTextNotEmpty(email) && ValidationUtils.isTextNotEmpty(password)) {
            if (db.login_driver(email, password)) {
                Toast.makeText(requireActivity(), "Driver logged in!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_login_to_home)
            } else if (db.login_passenger(email, password)) {
                Toast.makeText(requireActivity(), "Passenger logged in!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_login_to_home)
            } else {
                Toast.makeText(requireActivity(), "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(requireActivity(), "Enter all fields!", Toast.LENGTH_SHORT).show()
        }
    }

}