package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentSignupChoiceBinding
import com.example.jeep_need.databinding.FragmentSignupDriverBinding

class Signup_Driver : Fragment() {
    private lateinit var binding: FragmentSignupDriverBinding


    private lateinit var db: SQLiteOpenHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSignupDriverBinding.inflate(inflater, container, false)

        binding.textView24.setOnClickListener {
            findNavController().navigate(R.id.action_signup_Driver_to_login)

        }


        binding.tvSignIn.setOnClickListener {
            registerDriver()
        }
        return binding.root
    }
    private fun registerDriver() {
        val name = binding.tiEtUserName.text.toString()
        val phone = binding.tiEtEmail.text.toString()
        val email = binding.tiEtCellNo.text.toString()
        val password = binding.tiEtPassword.text.toString()
        db = SQLiteOpenHelper(requireActivity())



        if (
            ValidationUtils.isTextNotEmpty(name) &&
            ValidationUtils.isTextNotEmpty(phone) &&
            ValidationUtils.isTextNotEmpty(email) &&
            ValidationUtils.isTextNotEmpty(password)
        ) {
            val user = db.register(name,phone,email,password)
            if (user)   {
                Toast.makeText(requireActivity(), "User registered!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signup_Driver_to_login)
            } else {
                Toast.makeText(requireActivity(), "User registered!", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_signup_Driver_to_login)
            }
        } else {
            Toast.makeText(requireActivity(), "Please input all the fields!", Toast.LENGTH_LONG).show()
        }
    }
}