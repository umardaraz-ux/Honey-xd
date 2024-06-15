package com.example.foodu_deliveryapp.GridlayoutRecyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodu_deliveryapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolderItems> {

    int []arr;
    String[] foodTypes; // Array to hold the types of food
    // Other member variables and methods
    public Adapter(int[] arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolderItems onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
        MyViewHolderItems myViewHolderItems= new MyViewHolderItems(view);
        return myViewHolderItems;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolderItems holder, int position) {
        String foodType = foodTypes[position]; // Get the food type for the current position

        //MAIN FOOD IMAGE!!!
// Obtain the StorageReference for your image in Firebase Storage

        StorageReference imageRef = FirebaseStorage.getInstance().getReference().child("Food Images/pizzadone.png");

// Obtain the download URL of the image
        imageRef.getDownloadUrl().addOnSuccessListener(uri -> {
            String imageUrl = uri.toString();

            // Use Picasso to load the image into your ImageView
            Picasso.get().load(imageUrl).into(holder.imagex);
        }).addOnFailureListener(exception -> {
            // Handle any errors that may occur while obtaining the download URL
            Log.e("TAG", "Failed to get download URL: " + exception.getMessage());
        });

        //------------------------------------------------------------------------------------//
        //FOOD NAME

        // Get reference to the "text" node in Firebase Realtime Database
        DatabaseReference textrefxd = FirebaseDatabase.getInstance().getReference().child("Pizza XD");

        // Attach a ValueEventListener to read the data from Firebase
        textrefxd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@android.support.annotation.NonNull DataSnapshot dataSnapshot) {
                // Retrieve the text from the dataSnapshot
                String text = dataSnapshot.getValue(String.class);
                // Update the TextView with the retrieved text
                holder.namex.setText(text);
            }

            @Override
            public void onCancelled(@android.support.annotation.NonNull DatabaseError databaseError) {

            }
        });

        //------------------------------------------------------------------------------------//



    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class MyViewHolderItems extends RecyclerView.ViewHolder {

        ImageView imagex,starratingx;

        TextView pricetagx,namex,textratingx,kilometex,deltimex;

        public MyViewHolderItems(@NonNull View itemView) {
            super(itemView);

            imagex=itemView.findViewById(R.id.saladimage);
            starratingx=itemView.findViewById(R.id.staring);
            pricetagx=itemView.findViewById(R.id.pricetag);
            namex=itemView.findViewById(R.id.foodnames);
            textratingx=itemView.findViewById(R.id.ratingstext);
            kilometex=itemView.findViewById(R.id.distanceorkm);
            deltimex=itemView.findViewById(R.id.timeofdelivery);
        }
    }
}



