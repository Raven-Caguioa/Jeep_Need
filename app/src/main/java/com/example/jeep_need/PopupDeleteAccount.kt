package com.example.jeep_need

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.jeep_need.databinding.FragmentPopupDelAccBinding

class PopupDeleteAccount : DialogFragment() {
    private lateinit var binding: FragmentPopupDelAccBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPopupDelAccBinding.inflate(inflater,container,false)

        val dialogWindow = dialog?.window
        dialogWindow?.setBackgroundDrawableResource(R.drawable.background_border)
        binding.btYes.setOnClickListener {
            findNavController().navigate(R.id.action_popupDeleteAccount_to_deleteAccount)
            dismiss()
        }
        binding.btNo.setOnClickListener {
            dismiss()
        }
        return binding.root
    }
}

