package com.example.finalprojectisro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        // Initialize the ImageView and RelativeLayout for the Google image
        ImageView googleImageView = findViewById(R.id.google_image_view);
        RelativeLayout googleLayout = findViewById(R.id.google_layout);

        // Set an onClickListener on the RelativeLayout or ImageView
        googleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open a URL, modify this as needed
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://samsa8.github.io/NRSC-Jeedimetla-website/"));
                startActivity(browserIntent);
            }
        });
    }
}
