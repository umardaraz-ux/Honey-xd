//package com.example.foodu_deliveryapp.menuAdaptercard;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.foodu_deliveryapp.R;
//
//import java.util.ArrayList;
//
//public class Adaptermenu extends RecyclerView.Adapter<Adaptermenu.viewholder> {
//
//    ArrayList<Modelclassmenu> datalist;
//
//    public Adaptermenu(ArrayList<Modelclassmenu> datalist) {
//        this.datalist = datalist;
//    }
//
//    @NonNull
//    @Override
//    public Adaptermenu.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        View view = inflater.inflate(R.layout.work_layout3, parent, false);
//        return new viewholder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Adaptermenu.viewholder holder, int position) {
//
//        final Modelclassmenu temp = datalist.get(position);
//        holder.nameView.setText(temp.getName());
//        holder.nameView.setText(temp.getName());
//        holder.nameView.setText(temp.getName());
//
//        holder.imageView.setImageResource(temp.getImage());
//    }
//
//    @Override
//    public int getItemCount() {
//        return datalist.size();
//    }
//
//    public class viewholder extends RecyclerView.ViewHolder {
//        TextView nameView, emailView;
//        ImageView imageView;
//
//        public viewholder(@NonNull View itemView) {
//            super(itemView);
//
//            nameView = itemView.findViewById(R.id.saladspecial);
//            nameView = itemView.findViewById(R.id.resturantname);
//            nameView = itemView.findViewById(R.id.textchange);
//            imageView = itemView.findViewById(R.id.specialimage);
//        }
//    }
//}
