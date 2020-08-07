package com.example.fitnessapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Models.Appointment;
import com.example.fitnessapp.Models.Trainer;
import com.example.fitnessapp.R;

import java.util.List;

public class ProfileAppointmentAdapter extends RecyclerView.Adapter<ProfileAppointmentAdapter.ProfileAppointmentViewHolder> {

    private List<Appointment> appointments;

    public ProfileAppointmentAdapter(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @NonNull
    @Override
    public ProfileAppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.profile_appointment, parent, false);

        ProfileAppointmentViewHolder viewHolder = new ProfileAppointmentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAppointmentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public static class ProfileAppointmentViewHolder extends RecyclerView.ViewHolder{
        public ProfileAppointmentViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
