/*
 * Title:       Semesterabgabe Programmierung 4
 * Task:        Abdroid Application
 * Author:      Aleixo Alonso; m27597
 * Date:        August 9th, 2021
 */

package com.example.m27597fuelapp.ui.consumption;

/**
 * "ConsumptionFragment" class of this application contains methods to calculate fuel economy. This
 * class contains methods also found in "MainActivity". The existence of this class is necessary,
 * for this is new fragment.
 *
 * @author Aleixo Alonso
 */
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.m27597fuelapp.R;

public class ConsumptionFragment extends Fragment {

    //Declaration of "double" variables to calculate decimals.
    double odo1;
    double odo2;
    double trip;
    double fuelVol;
    double consumption;
    double consumptionRounded;

    //User input
    EditText odoStartInput;
    EditText odoEndInput;
    EditText fuelVolInput;

    //Button
    Button calcConsumptionButton;

    /**
     * User input is required to calculate consumption.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_consumption, container, false);

        //Get user input
        odoStartInput = (EditText) root.findViewById(R.id.odo1);
        odoEndInput = (EditText) root.findViewById(R.id.odo2);
        fuelVolInput = (EditText) root.findViewById(R.id.fuelVol);

        //Get button
        calcConsumptionButton = (Button) root.findViewById(R.id.calculateButton);
        calcConsumptionButton.setOnClickListener(new View.OnClickListener() {

            /**
             * In this method, if the user clicks the button "calculateButton", the user's input is
             * checked for validation. If the user has made an illegal input, they will have to
             * re-enter their values. If the input is accepted, the result "consumption" will be
             * rounded and returned as a string.
             * @param v
             */
            @Override
            public void onClick(View v) {
                odo1 = Float.valueOf(odoStartInput.getText().toString());
                odo2 = Float.valueOf(odoEndInput.getText().toString());
                fuelVol = Float.valueOf(fuelVolInput.getText().toString());

                //"if" statement to check input validity
                if (odo1 >= odo2 || fuelVol <= 0) {
                    Toast.makeText(getActivity(), "Please adjust your input!", Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(), "Odometer 2 must be greater than Odometer 1!", Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(), "Volume can't be 0!", Toast.LENGTH_LONG).show();
                } else {
                    trip = odo2 - odo1;
                    consumption = (fuelVol / trip) * 100;
                    consumptionRounded = Math.round(consumption * 100.0) / 100.0;
                    Toast.makeText(getActivity(), "You've spent " + String.valueOf(consumptionRounded) + " liters per 100km", Toast.LENGTH_LONG).show();
                }
            }
        });
        return root;
    }
}