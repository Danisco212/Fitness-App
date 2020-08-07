package com.example.fitnessapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitnessapp.Adapters.ProfileAppointmentAdapter;
import com.example.fitnessapp.Decorations.SpaceItemDecoration;
import com.example.fitnessapp.Models.Appointment;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    private RecyclerView appointments;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        appointments = view.findViewById(R.id.profileAppointments);
        init(view);
        return view;
    }

    private void init(View view){
        List<Appointment> appointments1 = new ArrayList<>();
        appointments1.add(new Appointment());
        appointments1.add(new Appointment());
        appointments1.add(new Appointment());
        appointments1.add(new Appointment());
        appointments1.add(new Appointment());
        appointments1.add(new Appointment());

        ProfileAppointmentAdapter appointmentAdapter = new ProfileAppointmentAdapter(appointments1);
        appointments.setAdapter(appointmentAdapter);
        appointments.setLayoutManager(new LinearLayoutManager(this.getContext()));
        appointments.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
    }

}
