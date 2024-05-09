package com.example.finalprojectisro;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CoreFunctionalitiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_functionalities); // Set the layout

        // Find TextViews for core functionalities
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewProcessor = findViewById(R.id.textViewProcessor);
        TextView textViewRAM = findViewById(R.id.textViewRAM);
        TextView textViewID = findViewById(R.id.textViewID);

        // You can set any additional TextViews here

        // Example: Set click listener on textViewName
        textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add functionality here when textViewName is clicked
            }
        });

        // You can set click listeners on other TextViews similarly
    }
}
