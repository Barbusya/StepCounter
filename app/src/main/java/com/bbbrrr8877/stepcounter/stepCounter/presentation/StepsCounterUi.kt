package com.bbbrrr8877.stepcounter.stepCounter.presentation

import android.widget.TextView

data class StepsCounterUi(private val count: Float) {

    fun map(steps: TextView) {
        steps.text = count.toString()
    }
}
