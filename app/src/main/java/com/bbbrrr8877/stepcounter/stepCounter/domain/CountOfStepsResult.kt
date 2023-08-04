package com.bbbrrr8877.stepcounter.stepCounter.domain

sealed class CountOfStepsResult {

    interface Mapper<T> {
        fun map(stepsCount: StepsCount, errorMessage: String): T
    }

    abstract fun <T> map(mapper: Mapper<T>): T

    data class Success(private val stepsCount: Float = 0F ) : CountOfStepsResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map((StepsCount(stepsCount)), "")
    }

    data class Failure(private val stepsCount: Float = 0F, private val message: String): CountOfStepsResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(StepsCount(stepsCount), message)
    }
}