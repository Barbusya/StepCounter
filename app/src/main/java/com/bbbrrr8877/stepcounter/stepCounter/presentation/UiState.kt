package com.bbbrrr8877.stepcounter.stepCounter.presentation

sealed class UiState {

    class Success: UiState() {

    }

    data class Error(private val message: String) : UiState() {

    }
}
