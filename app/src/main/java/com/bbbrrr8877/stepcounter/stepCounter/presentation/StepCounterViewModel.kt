package com.bbbrrr8877.stepcounter.stepCounter.presentation

import androidx.lifecycle.ViewModel
import com.bbbrrr8877.stepcounter.stepCounter.domain.StepCounterInteractor

class StepCounterViewModel(
    private val communication: StepCounterCommunication,
    private val interactor: StepCounterInteractor,
) : ViewModel() {

    
}