package com.bbbrrr8877.stepcounter.stepCounter.presentation

import com.bbbrrr8877.stepcounter.stepCounter.domain.CountOfStepsResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface HandleSteps {

    fun handle(
        coroutineScope: CoroutineScope,
        block: suspend () -> CountOfStepsResult
    )

    class Base(
        private val dispatcher: DispatchersList,
        private val countOfStepsResult: CountOfStepsResult.Mapper<Unit>,
    ) : HandleSteps {
        override fun handle(
            coroutineScope: CoroutineScope,
            block: suspend () -> CountOfStepsResult
        ) {
            coroutineScope.launch(dispatcher.io()) {
                val result = block.invoke()
                result.map(countOfStepsResult)
            }
        }
    }
}