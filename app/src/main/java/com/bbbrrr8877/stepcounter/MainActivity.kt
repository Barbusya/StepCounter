package com.bbbrrr8877.stepcounter

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bbbrrr8877.stepcounter.stepCounter.presentation.StepCounterFragment

class MainActivity : AppCompatActivity(), ShowFragment {
    //SensorEventListener


//    private var sensorManager: SensorManager? = null
//
//    private var running = false
//
//    private var totalSteps = 0f
//
//    private var previousTotalSteps = 0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            show(StepCounterFragment(), false)
//
//        loadData()
//        resetSteps()

//        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }



    private fun show(fragment: Fragment, add: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        val container = R.id.main_container
        if (add)
            transaction.add(container, fragment)
                .addToBackStack(fragment.javaClass.simpleName)
        else
            transaction.replace(container, fragment)
        transaction.commit()
    }

    override fun onResume() {
        super.onResume()
//        running = true
//
//        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
//
//        if (stepSensor == null) {
//            Toast.makeText(this, "No sensor detected on this device", Toast.LENGTH_LONG).show()
//        } else {
//            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
//        }
    }

    override fun show(fragment: Fragment) {
        show(fragment, true)
    }


//    override fun onSensorChanged(event: SensorEvent?) {
//
//        if (running) {
//            totalSteps = event!!.values[0]
//
//            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
//
//            binding.tvStepsTaken.text = "$currentSteps"
//        }
//    }

    //
//    fun resetSteps() {
//
//        binding.tvStepsTaken.setOnClickListener {
//            Toast.makeText(this, "Long tap to reset steps", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.tvStepsTaken.setOnClickListener {
//
//            previousTotalSteps = totalSteps
//
//            binding.tvStepsTaken.text = 0.toString()
//
//            saveData()
//
//            true
//        }
//    }
//
//    private fun saveData() {
//
//        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
//
//        val editor = sharedPreferences.edit()
//        editor.putFloat("key1", previousTotalSteps)
//        editor.apply()
//    }
//
//    private fun loadData() {
//
//        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
//        val savedNumber = sharedPreferences.getFloat("key1", 0f)
//
//        Log.d("MainActivity", "$savedNumber")
//
//        previousTotalSteps = savedNumber
//    }
//
//    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
//
//    }
}

interface ShowFragment {
    fun show(fragment: Fragment)

    class Empty : ShowFragment {
        override fun show(fragment: Fragment) = Unit
    }
}