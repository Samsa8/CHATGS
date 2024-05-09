package com.example.finalprojectisro;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class UserInputActivity extends AppCompatActivity {

    private EditText locationInput;
    private Button goButton;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageButton buttonDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
        locationInput = findViewById(R.id.userTextInput);
        goButton = findViewById(R.id.run_analysis_button);

        goButton.setOnClickListener(view -> {
            String location = locationInput.getText().toString().trim();
            if (!location.isEmpty()) {
                Intent intent = new Intent(UserInputActivity.this, WebViewActivity.class);
                intent.putExtra("location_name", location);
                startActivity(intent);
            } else {
                locationInput.setError("Please enter a location name");
            }
        });

        buttonDrawerToggle.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

        setupDrawerContent(navigationView);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(item -> {
            selectDrawerItem(item);
            return true;
        });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        int id = menuItem.getItemId();
        Intent intent;

        if (id == R.id.navQRcode) {
            intent = new Intent(UserInputActivity.this, DisplayImageActivity.class);
        } else if (id == R.id.navAbout) {
            intent = new Intent(UserInputActivity.this, AboutinfoActivity.class);
        } else if (id == R.id.navCorefunctionalities) {
            intent = new Intent(UserInputActivity.this, CoreFunctionalitiesActivity.class);
        } else if (id == R.id.navFeedback) {
            intent = new Intent(UserInputActivity.this, FeedbackActivity.class);
        } else {
            drawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
        startActivity(intent);
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
