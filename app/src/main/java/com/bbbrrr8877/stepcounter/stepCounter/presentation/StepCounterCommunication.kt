package com.bbbrrr8877.stepcounter.stepCounter.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface StepCounterCommunication {

    fun showState(uiState: UiState)

    class Base(
        private val state: StepCounterCommunication,
    ) : StepCounterCommunication {
        override fun showState(uiState: UiState) {
            TODO()
        }
    }
}

interface ObserveStepCounter {

    fun observeState(owner: LifecycleOwner, observer: Observer<UiState>)
}

interface StepStateCommunication : Communication.Mutable<UiState> {
    class Base : Communication.Post<UiState>(), StepStateCommunication
}