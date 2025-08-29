package com.synackdevnet.webcheck;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar loadingBar;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loadingBar = findViewById(R.id.loadingBar);
        simulateLoading();
    }

    private void simulateLoading() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progress += 10;
                loadingBar.setProgress(progress);
                if (progress < 100) {
                    handler.postDelayed(this, 300); 
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        };
        handler.postDelayed(runnable, 300);
    }
}