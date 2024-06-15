package com.example.foodu_deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.foodu_deliveryapp.OnboardingScreen.OnB_Layout;

public class Second_Welcome_sc2 extends AppCompatActivity {
    private Handler objj=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_welcome_sc2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent add=new Intent(Second_Welcome_sc2.this, OnB_Layout.class);
                startActivity(add);
            }
        },1800);
    }
}