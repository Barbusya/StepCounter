package com.bbbrrr8877.stepcounter.stepCounter.domain

interface HandleRequest {

    suspend fun handle(block: suspend () -> Unit): CountOfStepsResult

    class Base(
        private val handleError: HandleError,
        private val repository: StepsCounterRepository
    ) : HandleRequest {
        override suspend fun handle(block: suspend () -> Unit) = try {
            block.invoke()
            CountOfStepsResult.Success(repository.countSteps())
        } catch (e: Exception) {
            CountOfStepsResult.Failure(0F, handleError.handel(e))
        }
    }
}