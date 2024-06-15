package com.example.foodu_deliveryapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.foodu_deliveryapp.R;
import com.example.foodu_deliveryapp.favlongcardview.Modelclassfav;
import com.example.foodu_deliveryapp.favlongcardview.Adapterfav;

import java.util.ArrayList;


public class Fragment_menu_xdd extends Fragment {

    RecyclerView recyclerView;

    Adapterfav adapterfav;
    ArrayList<Modelclassfav> arrayList4;


    public Fragment_menu_xdd() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_xdd, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerviewmenu);
        arrayList4 = new ArrayList<>();
        arrayList4.add(new Modelclassfav("Special Shiratika", "Marhaba Mahal", "3000", "6000", R.drawable.img));
        arrayList4.add(new Modelclassfav("Special Lowcrabs", "Hardees", "6000", "12000", R.drawable.img));
        arrayList4.add(new Modelclassfav("Special Beef", "Bundoo khan", "8000", "16000", R.drawable.img));
        arrayList4.add(new Modelclassfav("Special alkane", "Arabic mandi", "1000", "2000", R.drawable.img));
        arrayList4.add(new Modelclassfav("Special Fattoush", "Papa Johns", "2000", "4000", R.drawable.img));
        arrayList4.add(new Modelclassfav("Special alkane", "Baba Tikka", "7000", "14000", R.drawable.img));
        arrayList4.add(new Modelclassfav("Special Spinach", "Chai Shai", "6000", "12000", R.drawable.img));


        adapterfav = new Adapterfav(arrayList4, getContext(), this); // Assuming your fragment implements OnItemClickListener
        recyclerView.setAdapter(adapterfav);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

}
