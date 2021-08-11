package com.example.m27597fuelapp.ui.consumption;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.m27597fuelapp.R;

public class ConsumptionFragment extends Fragment {

    private ConsumptionViewModel consumptionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        consumptionViewModel =
                new ViewModelProvider(this).get(ConsumptionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_consumption, container, false);
        final TextView textView = root.findViewById(R.id.text_consumption);
        consumptionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}