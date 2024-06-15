package com.example.foodu_deliveryapp.AddToCartMainPx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodu_deliveryapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class AddingToCartOnboard extends AppCompatActivity {

    TextView value;

    int count = 0;

    ImageButton add, sub;

    TextView dist,deltime,fname,ratetext,desclong,priceint;

    ImageView mainfoodimage,ratingstarimage;

    Button smallbtx, largebtx;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_to_cart_onboard);

        //Add Or Remove Buttons & Size Buttons i.e Food Large Or Small - Initializations

        // Initializations Images
        value = (TextView) findViewById(R.id.itemnumbers);
        add = findViewById(R.id.additembutton);
        smallbtx = findViewById(R.id.normalbutton);
        largebtx = findViewById(R.id.largebutton);
        mainfoodimage = findViewById(R.id.foodimagemain);
        ratingstarimage=findViewById(R.id.starsrating_main);
        sub = findViewById(R.id.removeitembutton);

        //------------------------------------------------------------------------------------//

        // Initialization Textviews

        dist=findViewById(R.id.distanceformain);
        deltime=findViewById(R.id.timedelivformain);
        fname=findViewById(R.id.foodnamemain);
        ratetext=findViewById(R.id.ratingtext_main);
        desclong=findViewById(R.id.desclongcontext_main);
        priceint=findViewById(R.id.priceXppText_main);


//MAIN FOOD IMAGE!!!
// Obtain the StorageReference for your image in Firebase Storage

        StorageReference imageRef = FirebaseStorage.getInstance().getReference().child("Food Images/salad3.png");

// Obtain the download URL of the image
        imageRef.getDownloadUrl().addOnSuccessListener(uri -> {
            String imageUrl = uri.toString();

            // Use Picasso to load the image into your ImageView
            Picasso.get().load(imageUrl).into(mainfoodimage);
        }).addOnFailureListener(exception -> {
            // Handle any errors that may occur while obtaining the download URL
            Log.e("TAG", "Failed to get download URL: " + exception.getMessage());
        });

        //------------------------------------------------------------------------------------//

//RATING STARS IMAGE

        // Obtain the StorageReference for your image in Firebase Storage

        StorageReference imageRefstarx = FirebaseStorage.getInstance().getReference().child("Rating Images/starxd.png");

// Obtain the download URL of the image
        imageRefstarx.getDownloadUrl().addOnSuccessListener(uri -> {
            String imageUrl = uri.toString();

            // Use Picasso to load the image into your ImageView
            Picasso.get().load(imageUrl).into(ratingstarimage);
        }).addOnFailureListener(exception -> {
            // Handle any errors that may occur while obtaining the download URL
            Log.e("TAG", "Failed to get download URL: " + exception.getMessage());
        });

        //------------------------------------------------------------------------------------//

        //DISTANCE

        // Get reference to the "text" node in Firebase Realtime Database
        DatabaseReference textref = FirebaseDatabase.getInstance().getReference().child("Distance");

        // Attach a ValueEventListener to read the data from Firebase
        textref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieve the text from the dataSnapshot
                String text = dataSnapshot.getValue(String.class);
                // Update the TextView with the retrieved text
                dist.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors
                Toast.makeText(AddingToCartOnboard.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });

        //------------------------------------------------------------------------------------//


        //DELIVERY TIME

        // Get reference to the "text" node in Firebase Realtime Database
        DatabaseReference textrefx = FirebaseDatabase.getInstance().getReference().child("Delivery Time");

        // Attach a ValueEventListener to read the data from Firebase
        textrefx.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieve the text from the dataSnapshot
                String text = dataSnapshot.getValue(String.class);
                // Update the TextView with the retrieved text
                deltime.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors
                Toast.makeText(AddingToCartOnboard.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });

        //------------------------------------------------------------------------------------//

        //FOOD NAME

        // Get reference to the "text" node in Firebase Realtime Database
        DatabaseReference textrefxd = FirebaseDatabase.getInstance().getReference().child("Food Name");

        // Attach a ValueEventListener to read the data from Firebase
        textrefxd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieve the text from the dataSnapshot
                String text = dataSnapshot.getValue(String.class);
                // Update the TextView with the retrieved text
                fname.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors
                Toast.makeText(AddingToCartOnboard.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });

        //------------------------------------------------------------------------------------//

        //RATING TEXT

        // Get reference to the "text" node in Firebase Realtime Database
        DatabaseReference textrefxds = FirebaseDatabase.getInstance().getReference().child("Rating Text");

        // Attach a ValueEventListener to read the data from Firebase
        textrefxds.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieve the text from the dataSnapshot
                String text = dataSnapshot.getValue(String.class);
                // Update the TextView with the retrieved text
                ratetext.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors
                Toast.makeText(AddingToCartOnboard.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });

        //------------------------------------------------------------------------------------//


        //DESCRIPTION

        // Get reference to the "text" node in Firebase Realtime Database
        DatabaseReference textdesc = FirebaseDatabase.getInstance().getReference().child("Description");

        // Attach a ValueEventListener to read the data from Firebase
        textdesc.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieve the text from the dataSnapshot
                String text = dataSnapshot.getValue(String.class);
                // Update the TextView with the retrieved text
                desclong.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors
                Toast.makeText(AddingToCartOnboard.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });

        //------------------------------------------------------------------------------------//


        //PRICE
        // Get reference to the "text" node in Firebase Realtime Database
        DatabaseReference textrefxdsxs = FirebaseDatabase.getInstance().getReference().child("Price");

        // Attach a ValueEventListener to read the data from Firebase
        textrefxdsxs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieve the text from the dataSnapshot
                String text = dataSnapshot.getValue(String.class);
                // Update the TextView with the retrieved text
                priceint.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors
                Toast.makeText(AddingToCartOnboard.this, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });

        //------------------------------------------------------------------------------------//

        smallbtx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Set background color and stroke for small button
                smallbtx.setBackgroundResource(R.drawable.button_selector_sizex);
                largebtx.setBackgroundResource(R.drawable.button_selector_second_sizex);

            }
        });

        largebtx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Set background color and stroke for large button
                largebtx.setBackgroundResource(R.drawable.button_selector_second_sizex);
                smallbtx.setBackgroundResource(R.drawable.button_selector_sizex);

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                increment(v);
            }

        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                decrement(v);
            }
        });
    }

    public void increment(View view) {
        count++;
        value.setText("" + count);
    }

    public void decrement(View view) {
        if (count <= 0) count = 0;
        else count--;
        value.setText("" + count);
    }

}