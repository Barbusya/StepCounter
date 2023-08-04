package com.bbbrrr8877.stepcounter.stepCounter.presentation

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bbbrrr8877.stepcounter.ShowFragment
import com.bbbrrr8877.stepcounter.databinding.FragmentCounterBinding

class StepCounterFragment : Fragment() {

    private var showFragment: ShowFragment = ShowFragment.Empty()

    private var _binding: FragmentCounterBinding? = null

    private var stepsCount = 0f
    private val binding: FragmentCounterBinding
        get() = _binding ?: throw RuntimeException("FragmentCounterBinding == null")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        showFragment = context as ShowFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvSteps.setOnClickListener {
            stepsCount++
            binding.tvStepsCount.text = stepsCount.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        showFragment = ShowFragment.Empty()
    }

}