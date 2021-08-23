/*
 * Title:       Semesterabgabe Programmierung 4
 * Task:        Android Application
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.m27597fuelapp.R;
import com.example.m27597fuelapp.ui.consumption.ConsumptionFragment;

public class RateFragment extends Fragment {

    //Used for logging
    private static final String TAG = ConsumptionFragment.class.getSimpleName();

    //Button
    Button sendRate;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        System.out.println("TAG = " + TAG);
        Log.d(TAG, "Loading " + TAG);

        View root = inflater.inflate(R.layout.fragment_rate, container, false);

        //Get button
        Log.d(TAG, "Getting button...");
        sendRate = (Button) root.findViewById(R.id.rateButton);

        Log.d(TAG, "Create onClickListener");
        sendRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Displaying message...");
                Toast.makeText(getActivity(), "Thank you for your review!", Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}