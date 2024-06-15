package com.example.foodu_deliveryapp.Saladviewcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodu_deliveryapp.Fragments.AFragment;
import com.example.foodu_deliveryapp.R;



import java.util.ArrayList;

public class AdapterSalad extends RecyclerView.Adapter<AdapterSalad.Holderxd> {


    ArrayList<com.example.foodu_deliveryapp.Saladviewcard.ModelclassSalad> arrayList2;

    Context context2;

    public AdapterSalad(ArrayList<com.example.foodu_deliveryapp.Saladviewcard.ModelclassSalad> arrayList2, Context context2, AFragment aFragment) {
        this.arrayList2 = arrayList2;
        this.context2 = context2;
    }


    @NonNull
    @Override
    public AdapterSalad.Holderxd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //We need too inflate the layout

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.work_layout2, parent, false);
        return new Holderxd(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holderxd holder, int position) {
        final com.example.foodu_deliveryapp.Saladviewcard.ModelclassSalad temp = arrayList2.get(position);

        holder.name.setText(temp.getName());
        holder.name1.setText(temp.getName1());
        holder.name2.setText(temp.getName2());
        holder.name3.setText(temp.getName3());
        holder.name4.setText(temp.getName4());
        holder.image.setImageResource(temp.getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList2.size();
    }

    public class Holderxd extends RecyclerView.ViewHolder {

        TextView name,name1,name2,name3,name4;

        ImageView image;


        public Holderxd(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.pricetag);
            name1 = itemView.findViewById(R.id.foodnames);
            name2 = itemView.findViewById(R.id.ratingstext);
            name3 = itemView.findViewById(R.id.distanceorkm);
            name4 = itemView.findViewById(R.id.timeofdelivery);
            image = itemView.findViewById(R.id.saladimage);

        }
    }
}