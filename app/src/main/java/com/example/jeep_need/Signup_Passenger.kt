package com.example.jeep_need
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentSignupPassengerBinding

class Signup_Passenger : Fragment() {
    private lateinit var binding: FragmentSignupPassengerBinding
    private lateinit var imageView4 : ImageView
    private lateinit var btPassenger : TextView
    private lateinit var db: SQLiteOpenHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentSignupPassengerBinding.inflate(inflater, container, false)


        binding.imageView4.setOnClickListener {
            register()
        }
        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signup_Passenger_to_login)
        }
        return binding.root
    }
    private fun register() {
        val name = binding.tiEtUserName.text.toString()
        val phone = binding.tiEtEmail.text.toString()
        val email = binding.tiEtCellNo.text.toString()
        val password = binding.tiEtPassword.text.toString()

        val confirmPassword = binding.tiEtConfirmPassword.text.toString()

        db = SQLiteOpenHelper(requireActivity())

        if (ValidationUtils.isTextNotEmpty(name) &&
            ValidationUtils.isTextNotEmpty(phone) &&
            ValidationUtils.isTextNotEmpty(email) &&

            ValidationUtils.isTextNotEmpty(password)&&
            ValidationUtils.isTextNotEmpty(confirmPassword)
        ) {
            val user = db.register2(name,phone,email,password)
            if(password != confirmPassword){
                Toast.makeText(requireActivity(), "password not match!", Toast.LENGTH_LONG).show()
            }
            else if (user) {
                Toast.makeText(requireActivity(), "User registered!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signup_Passenger_to_login)}
            else {
                Toast.makeText(requireActivity(), "User registered!", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_signup_Passenger_to_login)
            }
        }
        else {
            Toast.makeText(requireActivity(), "Please input all the fields!", Toast.LENGTH_LONG).show()
        }
    }
}