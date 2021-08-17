/*
 * Title:       Semesterabgabe Programmierung 4
 * Task:        Abdroid Application
 * Author:      Aleixo Alonso; m27597
 * Date:        August 9th, 2021
 */

package com.example.m27597fuelapp.ui.about;

/**
 * "AboutFragment" navigation fragment.
 *
 * @author Aleixo Alonso
 */
import android.os.Bundle;
import android.util.Log;
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
import com.example.m27597fuelapp.ui.consumption.ConsumptionFragment;

public class AboutFragment extends Fragment {

    //Used for logging
    private static final String TAG = ConsumptionFragment.class.getSimpleName();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        System.out.println("TAG = " + TAG);
        Log.d(TAG, "Loading " + TAG);

        View root = inflater.inflate(R.layout.fragment_about, container, false);

        return root;
    }
}