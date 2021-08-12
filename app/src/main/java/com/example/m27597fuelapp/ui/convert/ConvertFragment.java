/*
 * Title:       Semesterabgabe Programmierung 4
 * Task:        Abdroid Application
 * Author:      Aleixo Alonso; m27597
 * Date:        August 9th, 2021
 */

package com.example.m27597fuelapp.ui.convert;

/**
 * "ConvertFragment" class of this application contains methods to calculate unit conversion.
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

public class ConvertFragment extends Fragment {

    //Declaration of "double" variables to calculate decimals.
    double perGallon;
    double perKilo;
    double resultKilo;
    double resultGallon;
    double resultKiloRounded;
    double resultGallonRounded;

    //User input
    EditText kiloInput;
    EditText gallonInput;

    //Button
    Button calcMPGButton;
    Button calcKiloButton;

    /**
     * User input is required to calculate conversion.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_convert, container, false);

        //Get user input
        kiloInput = (EditText) root.findViewById(R.id.literKilo);
        gallonInput = (EditText) root.findViewById(R.id.MPG);

        //Get button
        calcMPGButton = (Button) root.findViewById(R.id.mpgButton);
        calcMPGButton.setOnClickListener(new View.OnClickListener() {

            /**
             * In this method, if the user clicks the button "mpgButton", the user's input is
             * checked for validation. If the user has made an illegal input, they will have to
             * re-enter their values. If the input is accepted, the result "resultGallon" will be
             * rounded and returned as a string.
             * @param v
             */
            @Override
            public void onClick(View v) {
                perKilo = Float.valueOf(kiloInput.getText().toString());

                //"if" statement to check input validity
                if (perKilo <= 0) {
                    Toast.makeText(getActivity(), "Please adjust your input!", Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(), "L/100 must be greater than 0!", Toast.LENGTH_LONG).show();
                } else {
                    resultGallon = 235.215 / perKilo; //Conversion formula
                    resultGallonRounded = Math.round(resultGallon * 100.0) / 100.0; //Rounding to 2 decimal points
                    Toast.makeText(getActivity(), perKilo + " L/100km is equal to " + resultGallonRounded + " Miles per Gallon.", Toast.LENGTH_LONG).show();
                }
            }
        });

        calcKiloButton = (Button) root.findViewById(R.id.kiloButton);
        calcKiloButton.setOnClickListener(new View.OnClickListener() {

            /**
             * In this method, if the user clicks the button "kiloButton", the user's input is
             * checked for validation. If the user has made an illegal input, they will have to
             * re-enter their values. If the input is accepted, the result "resultKilo" will be
             * rounded and returned as a string.
             * @param v
             */
            @Override
            public void onClick(View v) {
                perGallon = Float.valueOf(gallonInput.getText().toString());

                //"if" statement to check input validity
                if (perGallon <= 0) {
                    Toast.makeText(getActivity(), "Please adjust your input!", Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(), "MPG must be greater than 0!", Toast.LENGTH_LONG).show();
                } else {
                    resultKilo = 235.215 / perGallon; //Conversion formula
                    resultKiloRounded = Math.round(resultKilo * 100.0) / 100.0; //Rounding to 2 decimal points
                    Toast.makeText(getActivity(), perGallon + " Miles per Gallon is equal to " + resultKiloRounded + " L/100km.", Toast.LENGTH_LONG).show();
                }
            }
        });
        return root;
    }
}