package com.bbbrrr8877.stepcounter.stepCounter.presentation

import com.bbbrrr8877.stepcounter.stepCounter.domain.CountOfStepsResult
import com.bbbrrr8877.stepcounter.stepCounter.domain.StepsCount

class StepsCounterResultMapper(
    private val communications: StepCounterCommunication,
    private val mapper: StepsCount.Mapper<StepsCounterUi>,
) : CountOfStepsResult.Mapper<Unit> {

    override fun map(stepsCount: StepsCount, errorMessage: String) = communications.showState(
        if (errorMessage.isEmpty()) {
            communications.showSteps(stepsCount.map(mapper))
            UiState.Success()
        } else {
            UiState.Error(errorMessage)
        }
    )
}