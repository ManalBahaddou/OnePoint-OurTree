package com.example.onepoint_ourtree.activities.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.onepoint_ourtree.activities.BaseActivities;
import com.example.onepoint_ourtree.activities.main.MainActivity;
import com.example.onepoint_ourtree.R;
import com.example.onepoint_ourtree.configs.AppConfig;

public class SplashActivity extends BaseActivities {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init(this);
        new Handler(Looper.getMainLooper()).postDelayed(()->goToMain(), AppConfig.SPLASH_DISPLAY_TIME);
    }

    private void goToMain() {
        if (!isFinishing()){
            startActivity(new Intent(context, MainActivity.class));
            finish();
        }
    }
}