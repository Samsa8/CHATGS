package com.example.finalprojectisro;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AboutinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutinfo);
        populateOpeningHours();
        setupMapButton();
    }

    private void populateOpeningHours() {
        TableLayout tableLayout = findViewById(R.id.opening_hours_table);
        tableLayout.removeAllViews(); // Clear previous views if any

        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[] hours = {"Closed", "8:30 am - 5:30 pm", "8:30 am - 5:30 pm", "8:30 am - 5:30 pm", "8:30 am - 5:30 pm", "8:30 am - 5:30 pm", "Closed"};
        int today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;

        for (int i = 0; i < days.length; i++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            TextView dayView = new TextView(this);
            dayView.setText(days[i]);
            dayView.setTextSize(16);
            dayView.setPadding(0, 0, 16, 0);
            dayView.setGravity(Gravity.START);

            TextView hourView = new TextView(this);
            hourView.setText(hours[i]);
            hourView.setTextSize(16);
            hourView.setPadding(16, 0, 0, 0);
            hourView.setGravity(Gravity.END);

            row.addView(dayView);
            row.addView(hourView);
            tableLayout.addView(row);

            if (i == today) {
                dayView.setTextColor(Color.BLUE);
                dayView.setTypeface(null, Typeface.BOLD);
                hourView.setTextColor(Color.BLUE);
                hourView.setTypeface(null, Typeface.BOLD);
            } else {
                dayView.setTextColor(Color.BLACK);
                hourView.setTextColor(Color.BLACK);
            }
        }
    }

    private void setupMapButton() {
        Button showOnMapButton = findViewById(R.id.show_on_map_button);
        showOnMapButton.setOnClickListener(v -> {
            Uri mapUri = Uri.parse("https://maps.app.goo.gl/aGhpbEygGMV6Ur628");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
            // Optional: you can remove setPackage to allow any app to handle this URL
            // mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                // Optional: Consider adding a fallback or a message to the user
                Toast.makeText(AboutinfoActivity.this, "No application available to view the map.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
