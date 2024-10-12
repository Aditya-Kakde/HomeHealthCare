package com.example.homehealthcareapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.homehealthcareapp.Caretaker.CaretakerDashboardActivity
import com.example.homehealthcareapp.Patient.PatientDashboardActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val patientButton = findViewById<Button>(R.id.button_patient_dashboard)
        val caretakerButton = findViewById<Button>(R.id.button_caretaker_dashboard)

        patientButton.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                PatientDashboardActivity::class.java
            )
            startActivity(intent)
        }

        caretakerButton.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                CaretakerDashboardActivity::class.java
            )
            startActivity(intent)
        }
    }
}
