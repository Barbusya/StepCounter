package com.bbbrrr8877.stepcounter.stepCounter.domain

interface StepsCounterRepository {

    suspend fun countSteps(): Float
}