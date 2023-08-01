package com.bbbrrr8877.stepcounter.stepCounter.domain

sealed class CountOfStepsResult {

    interface Mapper<T> {
        fun map(count: Float, errorMessage: String): T
    }

    abstract fun <T> map(mapper: Mapper<T>): T

    data class Success(private val count: Float = 0f) : CountOfStepsResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(count, "")
    }

    class Failure(private val message: String): CountOfStepsResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(0f, message)
    }
}