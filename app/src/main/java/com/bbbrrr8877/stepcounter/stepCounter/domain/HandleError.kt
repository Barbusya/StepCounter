package com.bbbrrr8877.stepcounter.stepCounter.domain

import com.bbbrrr8877.stepcounter.R
import com.bbbrrr8877.stepcounter.stepCounter.presentation.ManageResources

interface HandleError {

    fun handel(e: Exception): String

    class Base(private val manageResources: ManageResources) : HandleError {
        override fun handel(e: Exception) = manageResources.string(R.string.sensor_no_permission)
    }
}