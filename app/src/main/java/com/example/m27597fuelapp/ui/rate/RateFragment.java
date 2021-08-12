package com.example.m27597fuelapp.ui.rate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.m27597fuelapp.R;

public class RateFragment extends Fragment {

    Button sendRate;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_rate, container, false);

        sendRate = (Button) root.findViewById(R.id.rateButton);
        sendRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Thank you for your review!", Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}