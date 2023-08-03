package com.bbbrrr8877.stepcounter.stepCounter.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bbbrrr8877.stepcounter.stepCounter.domain.StepCounterInteractor

class StepCounterViewModel(
    private val handleSteps: HandleSteps,
    private val communication: StepCounterCommunication,
    private val interactor: StepCounterInteractor,
) : ViewModel(), FetchStepsCount, ObserveStepCounter {

    override fun observeState(owner: LifecycleOwner, observer: Observer<UiState>) =
        communication.observeState(owner, observer)

    override fun observeSteps(owner: LifecycleOwner, observer: Observer<StepsCounterUi>) {
        communication.observeSteps(owner, observer)
    }

    override fun fetchSteps() = handleSteps.handle(viewModelScope) {
        interactor.countSteps()
    }
}