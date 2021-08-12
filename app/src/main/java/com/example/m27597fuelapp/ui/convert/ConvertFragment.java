package com.example.m27597fuelapp.ui.convert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.example.m27597fuelapp.R;

import org.jetbrains.annotations.NotNull;

public class ConvertFragment extends Fragment {

    double perGallon;
    double perKilo;
    double resultKilo;
    double resultGallon;
    double resultKiloRounded;
    double resultGallonRounded;

    EditText kiloInput;
    EditText gallonInput;

    Button calcMPGButton;
    Button calcKiloButton;

    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_convert, container, false);

        kiloInput = (EditText) root.findViewById(R.id.literKilo);
        gallonInput = (EditText) root.findViewById(R.id.MPG);


        calcMPGButton = (Button) root.findViewById(R.id.mpgButton);
        calcMPGButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perKilo = Float.valueOf(kiloInput.getText().toString());
                resultGallon = 235.215 / perKilo;
                resultGallonRounded = Math.round(resultGallon * 100.0) / 100.0;

                Toast.makeText(getActivity(), perKilo + " L/100km is equal to " + resultGallonRounded + " Miles per Gallon.", Toast.LENGTH_LONG).show();
            }
        });

        calcKiloButton = (Button) root.findViewById(R.id.kiloButton);
        calcKiloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perGallon = Float.valueOf(gallonInput.getText().toString());
                resultKilo = 235.215 / perGallon;
                resultKiloRounded = Math.round(resultKilo * 100.0) / 100.0;

                Toast.makeText(getActivity(), perGallon + " Miles per Gallon is equal to " + resultKiloRounded + " L/100km.", Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }
}