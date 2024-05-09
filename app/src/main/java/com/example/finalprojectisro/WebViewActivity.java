package com.example.finalprojectisro;

// WebViewActivity.java

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private HashMap<String, String> waterLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        initializeWaterLevels(); // Initialize the water levels data

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        String locationName = getIntent().getStringExtra("location_name");
        String level = waterLevels.getOrDefault(locationName, "Water Level Data not available");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                webView.evaluateJavascript("javascript:displayLocation('" + locationName + "');", null);
            }
        });

        webView.loadUrl("file:///android_asset/world_map.html");
    }

    private void initializeWaterLevels() {
        waterLevels = new HashMap<>();
        waterLevels.put("Musi River, Hyderabad", "10 feet");
        waterLevels.put("Hussain Sagar, Hyderabad", "15 feet");
        waterLevels.put("Durgam Cheruvu, Hyderabad", "8 feet");
    }
}
