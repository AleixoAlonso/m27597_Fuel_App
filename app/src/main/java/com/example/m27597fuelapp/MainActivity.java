/*
 * Title:       Semesterabgabe Programmierung 4
 * Task:        Abdroid Application
 * Author:      Aleixo Alonso; m27597
 * Date:        August 9th, 2021
 *
 * Description: This android application lets the user calculate their vehicle's fuel consumption
 *              based on the distance travelled and the amount of fuel that was spent. This works
 *              best if the user fills their tank completely so they can more easily tell the
 *              amount spent.
 *              The user may also convert their consumption from liters per 100km to miles per
 *              gallon. Other functions of this application are:
 *
 *              - Share fragment
 *              - Rate fragment
 *              - About fragment
 *              - Tooltip button
 */

package com.example.m27597fuelapp;

/**
 * "MainActivity" class of this application contains methods to calculate fuel economy, display a
 * message and open the drawer navigation.
 *
 * @author Aleixo Alonso
 */
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

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

    private AppBarConfiguration mAppBarConfiguration;

    /**
     * "onCreate" method to load all necessary data.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get user input
        odoStartInput = (EditText) findViewById(R.id.odo1);
        odoEndInput = (EditText) findViewById(R.id.odo2);
        fuelVolInput = (EditText) findViewById(R.id.fuelVol);

        //Get button
        calcConsumptionButton = (Button) findViewById(R.id.calculateButton);
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
                    showToast("Please adjust your input!");
                    showToast("Odometer 2 must be greater than Odometer 1!");
                    showToast("Volume can't be 0!");

                } else {
                    trip = odo2 - odo1;
                    consumption = (fuelVol / trip) * 100;
                    consumptionRounded = Math.round(consumption * 100.0) / 100.0;
                    showToast("You've spent " + String.valueOf(consumptionRounded) + " liters per 100km");
                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Tooltip button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            /**
             * Upon pressing this button, a tooltip for the user will be displayed.
             * @param view
             */
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Calculate fuel consumption or convert units!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Drawer layout containing different fragment destinations
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_consumption, R.id.nav_convert, R.id.nav_rate, R.id.nav_share, R.id.nav_about)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    /**
     * "onSupportNavigateUp" method used for navigation.
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    /**
     * Separate "showToast" method used to display calculation results.
     * @param text
     */
    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}