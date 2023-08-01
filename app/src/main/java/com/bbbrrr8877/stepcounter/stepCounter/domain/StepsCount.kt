package com.bbbrrr8877.stepcounter.stepCounter.domain

data class StepsCount(
    private val count: Float
) {

    fun <T> map(mapper: Mapper<T>): T = mapper.map(count)

    interface Mapper<T> {
        fun map(count: Float): T
    }

}
