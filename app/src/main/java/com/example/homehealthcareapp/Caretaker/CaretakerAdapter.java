package com.example.homehealthcareapp.Caretaker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homehealthcareapp.R;

import java.util.List;

public class CaretakerAdapter extends RecyclerView.Adapter<CaretakerAdapter.ViewHolder> {
    private List<Caretaker> caretakers;

    public CaretakerAdapter(List<Caretaker> caretakers) {
        this.caretakers = caretakers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_caretaker, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Caretaker caretaker = caretakers.get(position);
        holder.name.setText(caretaker.getName());
        holder.specialization.setText(caretaker.getSpecialization());
        holder.experience.setText(String.valueOf(caretaker.getExperience()));
    }

    @Override
    public int getItemCount() {
        return caretakers.size();
    }

    public void updateList(List<Caretaker> newList) {
        caretakers = newList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, specialization, experience;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.caretaker_name);
            specialization = view.findViewById(R.id.caretaker_specialization);
            experience = view.findViewById(R.id.caretaker_experience);
        }
    }
}
