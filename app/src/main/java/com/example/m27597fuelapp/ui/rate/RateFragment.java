/*
 * Title:       Semesterabgabe Programmierung 4
 * Task:        Abdroid Application
 * Author:      Aleixo Alonso; m27597
 * Date:        August 9th, 2021
 */

package com.example.m27597fuelapp.ui.rate;

/**
 * "RateFragment" navigation fragment.
 *
 * @author Aleixo Alonso
 */
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.m27597fuelapp.R;

public class RateFragment extends Fragment {

    //Button
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