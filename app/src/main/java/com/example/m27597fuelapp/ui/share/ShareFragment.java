/*
 * Title:       Semesterabgabe Programmierung 4
 * Task:        Abdroid Application
 * Author:      Aleixo Alonso; m27597
 * Date:        August 9th, 2021
 */

package com.example.m27597fuelapp.ui.share;

/**
 * "ShareFragment" navigation fragment.
 *
 * @author Aleixo Alonso
 */
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.m27597fuelapp.R;
import com.example.m27597fuelapp.ui.consumption.ConsumptionFragment;

public class ShareFragment extends Fragment {

    //Used for logging
    private static final String TAG = ConsumptionFragment.class.getSimpleName();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        System.out.println("TAG = " + TAG);
        Log.d(TAG, "Loading " + TAG);

        View root = inflater.inflate(R.layout.fragment_share, container, false);

        return root;
    }
}