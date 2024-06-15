package com.example.foodu_deliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodu_deliveryapp.Circularviewcard.Modelclass;
import com.example.foodu_deliveryapp.GridlayoutRecyclerview.Adapter;

import java.util.ArrayList;
import java.util.List;


public class ItemActvity extends AppCompatActivity {

    RecyclerView recyclerViewmainitems;
    RecyclerView.LayoutManager layoutManager;

    Adapter adapter;
    int []arr={R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,
            R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,
            R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,
            R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,
            R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_actvity);

        // Get foodType passed from CircularAdapter
        String foodType = getIntent().getStringExtra("Pizza");

        String[] foodTypes = {"Salad","Pizza","Burger","Shake","Pasta"}; // Array containing the types of food for each item

        // Filter items based on the selected foodType (e.g., "Pizza")
        List<Modelclass> pizzaItems = new ArrayList<>();
        for (int i = 0; i < foodTypes.length; i++) {
            if (foodTypes[i].equalsIgnoreCase(foodType)) {
                pizzaItems.add(new Modelclass(foodTypes[i], arr[i])); // Create pizza item model
            }
        }

//        // Create the adapter and pass the arr and foodTypes arrays
//        recyclerViewmainitems = findViewById(R.id.gridlayout); // Corrected this line
//        layoutManager = new GridLayoutManager(this, 2);
//        recyclerViewmainitems.setLayoutManager(layoutManager);
//
//        // Create the adapter and pass the arr and foodTypes arrays
//        Adapter adapter = new Adapter(arr, foodTypes);
//        recyclerViewmainitems.setAdapter(adapter);
//        recyclerViewmainitems.setHasFixedSize(true);


// Get foodType passed from CircularAdapter
//        String foodType = getIntent().getStringExtra("Pizza");

        recyclerViewmainitems = findViewById(R.id.gridlayout); // Corrected this line
        layoutManager = new GridLayoutManager(this, 2);
        recyclerViewmainitems.setLayoutManager(layoutManager);
        adapter = new Adapter(arr);
        recyclerViewmainitems.setAdapter(adapter);
        recyclerViewmainitems.setHasFixedSize(true);
    }
}