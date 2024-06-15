package com.example.foodu_deliveryapp.Circularviewcard;

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

public class Adapterview extends RecyclerView.Adapter<Adapterview.viewholder> {

    ArrayList<Modelclass> datalist;

    Context contextcircular;

    public Adapterview(ArrayList<Modelclass> datalist, Context contextcircular, AFragment aFragment) {
        this.datalist = datalist;
        this.contextcircular = contextcircular;
    }



    @NonNull
    @Override
    public Adapterview.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.work_layout, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterview.viewholder holder, int position) {

        final Modelclass temp = datalist.get(position);
        holder.nameView.setText(temp.getName());
        holder.imageView.setImageResource(temp.image);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView nameView;
        ImageView imageView;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            nameView = itemView.findViewById(R.id.textsalad);
            imageView = itemView.findViewById(R.id.salad);

        }
    }
}