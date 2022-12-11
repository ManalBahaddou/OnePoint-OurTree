package com.example.onepoint_ourtree.activities;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onepoint_ourtree.R;

public class BaseActivities extends AppCompatActivity {
    public Activity context;

    public void init(Activity activity){
        this.context = activity;
    }

    public void showLoader(){
        ViewGroup viewGroup = findViewById(R.id.progressBarContainer);
        if (viewGroup != null){
            viewGroup.setVisibility(View.VISIBLE);
        }
    }

    public void hideLoader(){
        ViewGroup viewGroup = findViewById(R.id.progressBarContainer);
        if (viewGroup != null){
            viewGroup.setVisibility(View.GONE);
        }
    }
}
