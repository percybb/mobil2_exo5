package com.example.exo5_termometro

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.getSystemService
import com.example.exo5_termometro.MyViews.Termometro

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager : SensorManager
    private lateinit var sensor :Sensor;
    private lateinit var termonetro: Termometro



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val READINGRATE = 1000000


        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        sensorManager.registerListener(this, sensor,SensorManager.SENSOR_DELAY_NORMAL,READINGRATE)

        termonetro = Termometro(this, 100.0f)
        setContentView(termonetro)
    }

    override fun onSensorChanged(p0: SensorEvent) {
        termonetro.setTemp(p0.values[0])
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}