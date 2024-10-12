package com.example.homehealthcareapp.Patient;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homehealthcareapp.Caretaker.Patient;
import com.example.homehealthcareapp.R;

import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    private List<Patient> patients;

    public PatientAdapter(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patient, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Patient patient = patients.get(position);
        holder.name.setText(patient.getName());
        holder.age.setText("Age: " + patient.getAge());
        holder.disease.setText("Disease: " + patient.getDisease());
        holder.careRequired.setText("Care: " + patient.getCareRequired());
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, age, disease, careRequired;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.patient_name);
            age = view.findViewById(R.id.patient_age);
            disease = view.findViewById(R.id.patient_disease);
            careRequired = view.findViewById(R.id.patient_care_required);
        }
    }
}
