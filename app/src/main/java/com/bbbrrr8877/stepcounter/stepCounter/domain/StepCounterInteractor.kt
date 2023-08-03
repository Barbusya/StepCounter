package com.bbbrrr8877.stepcounter.stepCounter.domain

interface StepCounterInteractor {

    suspend fun countSteps(): CountOfStepsResult

}