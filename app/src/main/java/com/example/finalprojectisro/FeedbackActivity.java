package com.example.finalprojectisro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_feedback); // Ensure this layout file correctly defines the buttons

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the "Feedback 1" button by its ID
        Button feedback1Button = findViewById(R.id.feedback1_button);
        // Set an OnClickListener for the "Feedback 1" button
        feedback1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the URL you want to redirect to for Feedback 1
                String url = "https://docs.google.com/forms/d/e/1FAIpQLSeC4m_PGcB4D7FErESgD5FXGyJ_Bg9kKs29zOYw79bIaa634g/viewform"; // Change this to your desired URL for Feedback 1
                // Create an intent to open the URL in a browser
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        // Find the "Feedback 2" button by its ID
        Button feedback2Button = findViewById(R.id.feedback2_button);
        // Set an OnClickListener for the "Feedback 2" button
        feedback2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the URL you want to redirect to for Feedback 2
                String url = "https://docs.google.com/forms/d/e/1FAIpQLSeeoeXMPfkgGVfbXC3cpHsly7RuVlkmyREJ6z9Fl2YdWmQDJA/viewform?pli=1"; // Change this to your desired URL for Feedback 2
                // Create an intent to open the URL in a browser
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
