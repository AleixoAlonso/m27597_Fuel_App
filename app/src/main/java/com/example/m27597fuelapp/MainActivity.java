package com.example.m27597fuelapp;

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

    double odo1;
    double odo2;
    double trip;
    double fuelVol;
    double consumption;
    double consumptionRounded;

    double perGallon;
    double perKilo;
    double resultKilo;
    double resultGallon;
    double resultKiloRounded;
    double resultGallonRounded;

    EditText odoStartInput;
    EditText odoEndInput;
    EditText fuelVolInput;
    EditText kiloInput;
    EditText gallonInput;

    Button calcConsumptionButton;
    Button calcMPGButton;
    Button calcKiloButton;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        odoStartInput = (EditText) findViewById(R.id.odo1);
        odoEndInput = (EditText) findViewById(R.id.odo2);
        fuelVolInput = (EditText) findViewById(R.id.fuelVol);

        kiloInput = (EditText) findViewById(R.id.literKilo);
        gallonInput = (EditText) findViewById(R.id.MPG);

        calcConsumptionButton = (Button) findViewById(R.id.calculateButton);
        calcMPGButton = (Button) findViewById(R.id.mpgButton);
        calcKiloButton = (Button) findViewById(R.id.kiloButton);

        calcMPGButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perKilo = Float.valueOf(kiloInput.getText().toString());

                resultGallon = 235.215 / perKilo;
                resultGallonRounded = Math.round(resultGallon * 100.0) / 100.0;

                //showToast( String.valueOf(kiloInput) + " L/100km is " + String.valueOf(resultGallonRounded) + " Miles per Gallon");
            }
        });

        calcKiloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perGallon = Float.valueOf(gallonInput.getText().toString());

                resultKilo = 235.215 / perGallon;
                resultKiloRounded = Math.round(resultKilo * 100.0) / 100.0;

                //showToast( String.valueOf(gallonInput) + " Miles per Gallon is " + String.valueOf(resultKiloRounded) + " L/100km");
            }
        });

        calcConsumptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odo1 = Float.valueOf(odoStartInput.getText().toString());
                odo2 = Float.valueOf(odoEndInput.getText().toString());
                fuelVol = Float.valueOf(fuelVolInput.getText().toString());

                trip = odo2 - odo1;
                consumption = (fuelVol / trip) * 100;
                consumptionRounded = Math.round(consumption * 100.0) / 100.0;

                showToast("You've spent " + String.valueOf(consumptionRounded) + " liters per 100km");
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Calculate fuel consumption or convert units!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_consumption, R.id.nav_convert, R.id.nav_rate, R.id.nav_share, R.id.nav_about)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}