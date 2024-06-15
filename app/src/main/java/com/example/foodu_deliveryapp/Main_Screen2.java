package com.example.foodu_deliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.foodu_deliveryapp.Fragments.AFragment;
import com.example.foodu_deliveryapp.Fragments.BFragment;
import com.example.foodu_deliveryapp.Fragments.CFragment;
import com.example.foodu_deliveryapp.Fragments.DFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_Screen2 extends AppCompatActivity {
BottomNavigationView bnview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen2);
        bnview=findViewById(R.id.boconti);
bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.nav_home){

            loadfrag(new AFragment(),false);
        }else if (id==R.id.nav_favourite){


            loadfrag(new BFragment(),false);
        }else if (id==R.id.nav_bell){

            loadfrag(new CFragment(),false);
        }else {

            loadfrag(new DFragment(),false);


        }
        return true;
    }
});
bnview.setSelectedItemId(R.id.nav_home);
    }
    public void loadfrag(Fragment fragment,boolean flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag)
        ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);
        ft.commit();
    }
}