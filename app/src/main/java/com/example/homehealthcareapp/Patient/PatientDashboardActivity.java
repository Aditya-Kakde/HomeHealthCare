package com.example.homehealthcareapp.Patient;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homehealthcareapp.Caretaker.Caretaker;
import com.example.homehealthcareapp.Caretaker.CaretakerAdapter;
import com.example.homehealthcareapp.Caretaker.CaretakerDatabaseHelper;
import com.example.homehealthcareapp.R;

import java.util.ArrayList;
import java.util.List;

public class PatientDashboardActivity extends AppCompatActivity {

    private RecyclerView caretakerRecyclerView;
    private CaretakerAdapter caretakerAdapter;
    private List<Caretaker> caretakerList = new ArrayList<>();
    private EditText searchCaretaker;
    private CaretakerDatabaseHelper caretakerDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        searchCaretaker = findViewById(R.id.searchCaretaker);
        caretakerRecyclerView = findViewById(R.id.caretakerRecyclerView);

        caretakerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        caretakerAdapter = new CaretakerAdapter(caretakerList);
        caretakerRecyclerView.setAdapter(caretakerAdapter);

        caretakerDatabaseHelper = new CaretakerDatabaseHelper(this);
        loadCaretakers();

        searchCaretaker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }

            private void filter(String text) {
                List<Caretaker> filteredList = new ArrayList<>();
                for (Caretaker caretaker : caretakerList) {
                    if (caretaker.getSpecialization().toLowerCase().contains(text.toLowerCase())) {
                        filteredList.add(caretaker);
                    }
                }
                caretakerAdapter.updateList(filteredList);
            }
        });
    }

    private void loadCaretakers() {
        SQLiteDatabase db = caretakerDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("caretakers", null, null, null, null, null, null);

        caretakerList.clear();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("caretaker_id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String specialization = cursor.getString(cursor.getColumnIndex("specialization"));
                @SuppressLint("Range") int experience = cursor.getInt(cursor.getColumnIndex("experience"));
                @SuppressLint("Range") double reviews = cursor.getDouble(cursor.getColumnIndex("reviews"));
                @SuppressLint("Range") int patientsHandled = cursor.getInt(cursor.getColumnIndex("patients_handled"));

                Caretaker caretaker = new Caretaker(id, name, specialization, experience, reviews, patientsHandled);
                caretakerList.add(caretaker);
            } while (cursor.moveToNext());
        }
        cursor.close();
        caretakerAdapter.notifyDataSetChanged();
    }
}
