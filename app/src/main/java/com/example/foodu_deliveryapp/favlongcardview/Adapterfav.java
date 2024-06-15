package com.example.foodu_deliveryapp.favlongcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodu_deliveryapp.Fragments.Fragment_menu_xdd;
import com.example.foodu_deliveryapp.R;

import java.util.ArrayList;

public class Adapterfav extends RecyclerView.Adapter<Adapterfav.viewholder> {

    ArrayList<Modelclassfav> arrayList4;

    Context context4;
    public Adapterfav(ArrayList<Modelclassfav> arraylist4, Context context4, Fragment_menu_xdd Fragmentmenuxdd) {

        this.arrayList4 = arraylist4;
        this.context4 = context4;
    }




    @NonNull
    @Override
    public Adapterfav.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.work_layout4, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterfav.viewholder holder, int position) {
        final Modelclassfav temp = arrayList4.get(position);

        holder.name.setText(temp.getName());
        holder.name1.setText(temp.getName1());
        holder.name2.setText(temp.getName2());
        holder.name3.setText(temp.getName3());
        holder.image.setImageResource(temp.getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList4.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView name, name1, name2,name3;

        ImageView image;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.saladspecial4);
            name1 = itemView.findViewById(R.id.resturantname4);
            name2 = itemView.findViewById(R.id.textchange4);
            name3 = itemView.findViewById(R.id.change4);
            image = itemView.findViewById(R.id.specialimage4);
        }
    }
}
