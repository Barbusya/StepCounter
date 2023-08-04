package com.bbbrrr8877.stepcounter.stepCounter.domain

interface StepCounterInteractor {

    suspend fun countSteps(): CountOfStepsResult

    class Base(
        private val repository: StepsCounterRepository,
        private val handleRequest: HandleRequest
    ) : StepCounterInteractor {
        override suspend fun countSteps(): CountOfStepsResult = handleRequest.handle {
            repository.countSteps()
        }
    }

}