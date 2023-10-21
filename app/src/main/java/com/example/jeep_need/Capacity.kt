package com.example.jeep_need

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jeep_need.databinding.FragmentJeepCapacityBinding


class Capacity : Fragment() {
    private lateinit var binding: FragmentJeepCapacityBinding
    private var capacity = 0
    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentJeepCapacityBinding.inflate(inflater, container, false)

        updateProgressBar()

        binding.btIncrease.setOnClickListener {
            if (capacity <= 95) {
                capacity += 5
                count += 1
                updateProgressBar()
            }
        }

        binding.btDecrease.setOnClickListener {
            if (capacity >= 5) {
                capacity -= 5
                count -= 1
                updateProgressBar()
            }
        }
        return binding.root

    }
    private fun updateProgressBar() {
        binding.capacityBar.progress = capacity
        binding.tvCapacityCount.text = "$count/20"
    }
}