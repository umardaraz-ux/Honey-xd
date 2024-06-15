package com.example.foodu_deliveryapp.Longcardview;

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

public class Adapterlong extends RecyclerView.Adapter<Adapterlong.viewholder> {

    ArrayList<ModelclassLong> arrayList3;

    Context context3;
    public Adapterlong(ArrayList<ModelclassLong> arraylist3, Context context3, AFragment aFragment) {
        this.arrayList3 = arraylist3;
        this.context3 = context3;
    }

    @NonNull
    @Override
    public Adapterlong.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.work_layout3, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterlong.viewholder holder, int position) {
        final ModelclassLong temp = arrayList3.get(position);

        holder.name.setText(temp.getName());
        holder.name1.setText(temp.getName1());
        holder.name2.setText(temp.getName2());
        holder.image.setImageResource(temp.getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList3.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView name, name1, name2;

        ImageView image;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.saladspecial);
            name1 = itemView.findViewById(R.id.resturantname);
            name2 = itemView.findViewById(R.id.textchange);
            image = itemView.findViewById(R.id.specialimage);
        }
    }
}
