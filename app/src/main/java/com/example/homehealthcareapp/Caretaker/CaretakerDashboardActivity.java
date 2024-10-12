package com.example.homehealthcareapp.Caretaker;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homehealthcareapp.Patient.PatientAdapter;
import com.example.homehealthcareapp.Patient.PatientDatabaseHelper;
import com.example.homehealthcareapp.R;

import java.util.ArrayList;
import java.util.List;

public class CaretakerDashboardActivity extends AppCompatActivity {

    private RecyclerView patientRecyclerView;
    private PatientAdapter patientAdapter;
    private List<Patient> patientList = new ArrayList<>();
    private PatientDatabaseHelper patientDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caretaker_dashboard);

        patientRecyclerView = findViewById(R.id.patientRecyclerView);
        patientRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        patientAdapter = new PatientAdapter(patientList);
        patientRecyclerView.setAdapter(patientAdapter);

        patientDatabaseHelper = new PatientDatabaseHelper(this);
        loadPatients();
    }

    private void loadPatients() {
        SQLiteDatabase db = patientDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("patients", null, null, null, null, null, null);

        patientList.clear();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("patient_id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex("age"));
                @SuppressLint("Range") String disease = cursor.getString(cursor.getColumnIndex("disease"));
                @SuppressLint("Range") String careRequired = cursor.getString(cursor.getColumnIndex("care_required"));
                @SuppressLint("Range") String medicalHistory = cursor.getString(cursor.getColumnIndex("medical_history"));

                Patient patient = new Patient(id, name, age, disease, careRequired, medicalHistory);
                patientList.add(patient);
            } while (cursor.moveToNext());
        }
        cursor.close();
        patientAdapter.notifyDataSetChanged();
    }
}
