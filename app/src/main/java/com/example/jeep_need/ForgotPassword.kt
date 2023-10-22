package com.example.jeep_need

import android.content.ContentValues
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentForgotPasswordBinding


class ForgotPassword : Fragment() {
    private lateinit var binding: FragmentForgotPasswordBinding
    private lateinit var btSignin : ImageView
    private lateinit var tvSignUp : ImageView
    private lateinit var db: SQLiteOpenHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(inflater,container,false)
        db = SQLiteOpenHelper(requireActivity())

        binding.btReturn.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPassword_to_login_nav)
        }
        binding.btUpdatePass.setOnClickListener {
            //findNavController().navigate(R.id.action_forgotPassword_to_login_nav)
            val username = binding.usernameFPass.text.toString()
            val email = binding.EmailFPass.text.toString()
            val newPassword = binding.NewPass.text.toString()
            val confirmNewPassword = binding.ConNewPass.text.toString()

            if (ValidationUtils.isTextNotEmpty(username) &&
                ValidationUtils.isTextNotEmpty(email) &&
                ValidationUtils.isTextNotEmpty(newPassword) &&

                ValidationUtils.isTextNotEmpty(confirmNewPassword)
            ) {
                val user = db.resetPassword(email, newPassword)
                val user2 = db.resetPassword2(email, newPassword)
                if (newPassword != confirmNewPassword) {
                    Toast.makeText(requireActivity(), "password not match!", Toast.LENGTH_LONG)
                        .show()
                } else if (user) {
                    Toast.makeText(requireActivity(), "password change", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_forgotPassword_to_login_nav)
                }else if (user2) {
                    Toast.makeText(requireActivity(), "password change", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_forgotPassword_to_login_nav)
                }
                else {
                    Toast.makeText(requireActivity(), "User registered!", Toast.LENGTH_LONG).show()
                    //findNavController().navigate(R.id.action_signup_Driver_to_login)
                }
            } else {
                Toast.makeText(requireActivity(), "Please input all the fields!", Toast.LENGTH_LONG)
                    .show()
            }

        }
        return binding.root
    }

}