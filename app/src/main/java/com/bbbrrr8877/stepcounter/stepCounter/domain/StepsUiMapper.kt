package com.bbbrrr8877.stepcounter.stepCounter.domain

import com.bbbrrr8877.stepcounter.stepCounter.presentation.StepsCounterUi

class StepsUiMapper : StepsCount.Mapper<StepsCounterUi> {
    override fun map(count: Float): StepsCounterUi = StepsCounterUi(count)
}