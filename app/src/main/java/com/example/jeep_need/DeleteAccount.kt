package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentDeleteAccountBinding
import com.example.jeep_need.databinding.FragmentProfileBinding

class DeleteAccount : Fragment() {
    private lateinit var binding: FragmentDeleteAccountBinding
    private lateinit var db: SQLiteOpenHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeleteAccountBinding.inflate(inflater, container, false)
        db = SQLiteOpenHelper(requireActivity())

        binding.btConfirm.setOnClickListener {
            AccDel()
        }
        binding.btCancel.setOnClickListener{
            findNavController().navigate(R.id.action_deleteAccount_to_profile)
        }
        return binding.root
    }

    private fun AccDel(){
        val userName = binding.confirmUsername.text.toString()
        val cPass = binding.confirmPass.text.toString()
        val cPass2 = binding.confirmPass2.text.toString()


        if(ValidationUtils.isTextNotEmpty(userName) || ValidationUtils.isTextNotEmpty(cPass) || ValidationUtils.isTextNotEmpty(cPass2)){
            val success = db.deleteAcc(userName)
            if (success){
                Toast.makeText(requireContext(), "Delete Success", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_deleteAccount_to_login_nav)
            }else{
                Toast.makeText(requireContext(), "Delete Failed", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(requireContext(), "Please Fill The Required Fields", Toast.LENGTH_SHORT).show()
        }


    }


}