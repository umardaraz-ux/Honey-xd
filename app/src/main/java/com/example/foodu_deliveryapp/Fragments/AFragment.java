package com.example.foodu_deliveryapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodu_deliveryapp.ItemActvity;
import com.example.foodu_deliveryapp.Saladviewcard.AdapterSalad;
import com.example.foodu_deliveryapp.Saladviewcard.ModelclassSalad;
import com.example.foodu_deliveryapp.Circularviewcard.Adapterview;
import com.example.foodu_deliveryapp.Circularviewcard.Modelclass;
import com.example.foodu_deliveryapp.Longcardview.Adapterlong;
import com.example.foodu_deliveryapp.Longcardview.ModelclassLong;
import com.example.foodu_deliveryapp.R;

import java.util.ArrayList;


public class AFragment extends Fragment {


    RecyclerView recyclerView;
    RecyclerView recyclerView1;

    RecyclerView recyclerView2;
    Adapterview adapterview;
    Adapterlong adapterlong;
    ArrayList<ModelclassLong> arrayList3;
    com.example.foodu_deliveryapp.Saladviewcard.AdapterSalad adapterSalad;
    ArrayList<com.example.foodu_deliveryapp.Saladviewcard.ModelclassSalad> arrayList2;
    ArrayList<Modelclass> datalist;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.recyclerviewcircular);
        recyclerView2 = view.findViewById(R.id.recyclerviewlongcard);
        recyclerView1 = view.findViewById(R.id.recyclerviewsalad);


        datalist = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        arrayList3 = new ArrayList<>();
        //Adding Salad Data
        datalist.add(new Modelclass("Salad", R.drawable.saladxd));
        datalist.add(new Modelclass("Pizza", R.drawable.pizzaxxd));
        datalist.add(new Modelclass("Burger", R.drawable.burgerxd));
        datalist.add(new Modelclass("Milk", R.drawable.babomilk));
        datalist.add(new Modelclass("Salad", R.drawable.salad2));
        datalist.add(new Modelclass("Pizza", R.drawable.pizzaxxd));
        datalist.add(new Modelclass("Pasta", R.drawable.pasta));


        arrayList2.add(new ModelclassSalad("12K", "Salad With Shiratika", "4.5", "2km", "15 min delivery", R.drawable.img));
        arrayList2.add(new ModelclassSalad("10K", "Salad With Lowcrabs", "4.5", "5km", "25 min delivery", R.drawable.img));
        arrayList2.add(new ModelclassSalad("15K", "Salad With Beef", "4.5", "1km", "07 min delivery", R.drawable.img));
        arrayList2.add(new ModelclassSalad("10K", "Salad With alkane", "4.5", "9km", "30 min delivery", R.drawable.img));
        arrayList2.add(new ModelclassSalad("11K", "Salad With Spinach", "4.5", "6km", "20 min delivery", R.drawable.img));
        arrayList2.add(new ModelclassSalad("20K", "Salad With Lowcrabs", "4.5", "3km", "10 min delivery", R.drawable.img));
        arrayList2.add(new ModelclassSalad("25K", "Salad With Fattoush", "4.5", "8km", "23 min delivery", R.drawable.img));
        arrayList2.add(new ModelclassSalad("55K", "Salad With Cobb", "4.5", "2km", "15 min delivery", R.drawable.img));
        arrayList2.add(new ModelclassSalad("09K", "Salad With alkane", "4.5", "7km", "18 min delivery", R.drawable.img));


        arrayList3.add(new ModelclassLong("Special Shiratika", "Marhaba Mahal", "3000", R.drawable.img));
        arrayList3.add(new ModelclassLong("Special Lowcrabs", "Hardees", "6000", R.drawable.img));
        arrayList3.add(new ModelclassLong("Special Beef", "Bundoo khan", "8000", R.drawable.img));
        arrayList3.add(new ModelclassLong("Special alkane", "Arabic mandi", "1000", R.drawable.img));
        arrayList3.add(new ModelclassLong("Special Fattoush", "Papa Johns", "2000", R.drawable.img));
        arrayList3.add(new ModelclassLong("Special alkane", "Baba Tikka", "7000", R.drawable.img));
        arrayList3.add(new ModelclassLong("Special Spinach", "Chai Shai", "6000", R.drawable.img));

        adapterview = new Adapterview(datalist, getContext(), this); // Assuming your fragment implements OnItemClickListener
        recyclerView.setAdapter(adapterview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        adapterSalad = new AdapterSalad(arrayList2, getContext(), this); // Assuming your fragment implements OnItemClickListener
        recyclerView1.setAdapter(adapterSalad);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        adapterlong = new Adapterlong(arrayList3, getContext(), this);
        recyclerView2.setAdapter(adapterlong);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


    }

    @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }


//
//    @Override
//
//    public void onItemClick(Modelclass item) {
//        // Handle item click here
//        // Launch the next activity and pass data
//        Intent intent = new Intent(getContext(), ItemActvity.class);
//        intent.putExtra("itemName", item.getName()); // Pass the item name to the next activity
//        startActivity(intent);
    }
