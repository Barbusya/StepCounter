package com.bbbrrr8877.stepcounter.stepCounter.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface StepCounterCommunication : ObserveStepCounter {

    fun showState(uiState: UiState)

    fun showSteps(stepsCounterUi: StepsCounterUi)

    class Base(
        private val state: StepStateCommunication,
        private val steps: StepsCountCommunication,
    ) : StepCounterCommunication {
        override fun showState(uiState: UiState) = state.map(uiState)
        override fun showSteps(stepsCounterUi: StepsCounterUi) = steps.map(stepsCounterUi)

        override fun observeState(owner: LifecycleOwner, observer: Observer<UiState>) =
            state.observe(owner, observer)

        override fun observeSteps(owner: LifecycleOwner, observer: Observer<StepsCounterUi>) =
            steps.observe(owner, observer)
    }

}

interface ObserveStepCounter {

    fun observeState(owner: LifecycleOwner, observer: Observer<UiState>)

    fun observeSteps(owner: LifecycleOwner, observer: Observer<StepsCounterUi>)
}

interface StepStateCommunication : Communication.Mutable<UiState> {
    class Base : Communication.Post<UiState>(), StepStateCommunication
}

interface StepsCountCommunication : Communication.Mutable<StepsCounterUi> {
    class Base : Communication.Post<StepsCounterUi>(), StepsCountCommunication
}