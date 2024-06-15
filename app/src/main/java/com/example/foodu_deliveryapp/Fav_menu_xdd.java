package com.example.foodu_deliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.foodu_deliveryapp.Fragments.Fragment_menu_xdd;
import com.example.foodu_deliveryapp.Fragments.Resturant_xdd;

public class Fav_menu_xdd extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_menu_xdd);

        Button buttonFragmentMenu = findViewById(R.id.menubutton);
        Button buttonFragmentRest = findViewById(R.id.restaurantbutton);
        FrameLayout fragmentContainer = findViewById(R.id.fragmentContainer);
//Default Frag to be shown in the recycler view
        buttonFragmentMenu.setSelected(true);
        buttonFragmentRest.setSelected(false);

        buttonFragmentMenu.setOnClickListener(v -> {getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new Fragment_menu_xdd())
                .commit();

            buttonFragmentRest.setSelected(false);
            buttonFragmentMenu.setSelected(true);
        });

        buttonFragmentRest.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Resturant_xdd())
                    .commit();
            buttonFragmentMenu.setSelected(false);
            buttonFragmentRest.setSelected(true);


        });
    }
}