package com.example.foodu_deliveryapp.AddToCartMainPx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.foodu_deliveryapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.UUID;

public class AdminPanel extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView selectImageButton;
    private Uri selectedImageUri; // Declare as class-level variable
    Spinner spinner;
    private String selectedCategory;
    Button uploadbutton;
    EditText edx1,edx2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        // Initialize Firebase
        FirebaseApp.initializeApp(this);
        spinner = findViewById(R.id.spinnerxd);
        selectImageButton = findViewById(R.id.imagebuttonx);
        uploadbutton = findViewById(R.id.UploadButton);
        edx1=findViewById(R.id.editText1);
        edx2=findViewById(R.id.editText2);

        uploadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productNameX = edx1.getText().toString().trim();
                String productSizeX = edx2.getText().toString().trim();

                if (productNameX.isEmpty() || productSizeX.isEmpty()) {
                    Toast.makeText(AdminPanel.this, "Enter Credentials", Toast.LENGTH_SHORT).show();
                } else if (selectedImageUri == null) {
                    // Show toast message if no image is selected
                    Toast.makeText(AdminPanel.this, "Select Image", Toast.LENGTH_SHORT).show();
                } else if (selectedCategory == null) {
                    Toast.makeText(AdminPanel.this, "Select a Category", Toast.LENGTH_SHORT).show();
                } else {
                    // Call the method to add data to Firebase and upload image
                    AddDatatoRealtimedatabase(productNameX, productSizeX, selectedCategory);
                    uploadImageToFirebaseStorage(selectedImageUri);
                }
            }
        });

//=======================================SPINNER VIEW====================================================//

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                // Store the selected category in the class-level variable
                selectedCategory = adapterView.getItemAtPosition(position).toString();

                Toast.makeText(AdminPanel.this, "Selected Category: " + selectedCategory, Toast.LENGTH_SHORT).show();

                //                String Categories = adapterView.getItemAtPosition(position).toString();
//
//                Toast.makeText(MainActivity.this, "Selected Item: " + Categories, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Electronics");
        arrayList.add("Groccery");
        arrayList.add("Home Appliances");
        arrayList.add("Smart Watches");
        arrayList.add("Mobile Phones");
        arrayList.add("Jewelery");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);


        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);

//=======================================IMAGE BUTTON GALLERY====================================================//

        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open gallery to select an image
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            // Get the URI of the selected image
            selectedImageUri = data.getData();

            // Do something with the URI. For example, load image to an ImageView
            selectImageButton.setImageURI(selectedImageUri);


//            // Call method to upload image to Firebase Storage
//            uploadImageToFirebaseStorage(selectedImageUri, "image.jpg");

        }
    }

    //=======================================ADDING FIREBASE DATA===============================================//
    //---------------------------------------------METHOD-------------------------------------------------------//
    //                                           STRING TYPE                                                    //

    public void AddDatatoRealtimedatabase(String productName, String productSize, String Category) {
        // Create an instance of AddData with product name, size, and category
        AddData obj = new AddData(productName, productSize, Category);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Products"); // Reference to your database node

        // Use push() to create a unique key for each product
        String uniqueKey = reference.push().getKey();

        // Add data to child in Firebase Realtime Database under the unique key
        if (uniqueKey != null) {
            reference.child(uniqueKey).setValue(obj).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(AdminPanel.this, "Data Added", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(AdminPanel.this, "Failed to add data", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(AdminPanel.this, "Failed to generate unique key", Toast.LENGTH_SHORT).show();
        }
    }


    //=======================================ADDING FIREBASE DATA===============================================//
    //---------------------------------------------METHOD-------------------------------------------------------//
    //                                           IMAGE TYPE                                                     //
    public void uploadImageToFirebaseStorage(Uri imageUri) {
        // Generate a unique name for the image
        String uniqueImageName = UUID.randomUUID().toString() + ".jpg";

        // Get Firebase Storage reference
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        // Create a reference to store the image with a unique name
        StorageReference imageRef = storageRef.child("images/" + uniqueImageName);

        // Upload the image to Firebase Storage
        imageRef.putFile(imageUri)
                .addOnSuccessListener(taskSnapshot -> {
                    // Image uploaded successfully
                    Toast.makeText(AdminPanel.this, "Image Uploaded to Firebase Storage", Toast.LENGTH_SHORT).show();

                    // Get the download URL of the uploaded image
                    imageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                        // Save the download URL to Firebase Realtime Database or perform other actions
                        String imageUrl = uri.toString();
                        // Handle the imageUrl (e.g., save to database)
                        saveImageUrlToDatabase(imageUrl, uniqueImageName);
                    }).addOnFailureListener(e -> {
                        // Handle failure to get download URL
                        Toast.makeText(AdminPanel.this, "Failed to get image download URL", Toast.LENGTH_SHORT).show();
                    });
                })
                .addOnFailureListener(e -> {
                    // Handle image upload failure
                    Toast.makeText(AdminPanel.this, "Failed to upload image to Firebase Storage", Toast.LENGTH_SHORT).show();
                });
    }

    private void saveImageUrlToDatabase(String imageUrl, String imageName) {
        // Save the imageUrl and imageName to the database
        // Implement your own logic here based on your requirements
        // For example:
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("ImageUrls");

        String uniqueKey = reference.push().getKey();
        if (uniqueKey != null) {
            reference.child(uniqueKey).setValue(new ImageData(imageUrl, imageName))
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(AdminPanel.this, "Image URL saved to database", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(e -> {
                        Toast.makeText(AdminPanel.this, "Failed to save image URL to database", Toast.LENGTH_SHORT).show();
                    });
        }
    }

    public static class ImageData {
        public String imageUrl;
        public String imageName;

        public ImageData() {
            // Default constructor required for calls to DataSnapshot.getValue(ImageData.class)
        }

        public ImageData(String imageUrl, String imageName) {
            this.imageUrl = imageUrl;
            this.imageName = imageName;
        }
    }
    //=======================================ADDING FIREBASE DATA===============================================//
    //---------------------------------------------METHOD-------------------------------------------------------//
    //                                          CATEGORY TYPE                                                   //
    private void uploadSelectedCategoryToFirebase(String category) {
        // You can implement the Firebase database upload logic here
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference categoryRef = database.getReference("Category");

        // Assuming you want to save the selected category under a specific node in Firebase
        categoryRef.setValue(category)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        Toast.makeText(AdminPanel.this, "Selected Category Uploaded to Firebase", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(AdminPanel.this, "Failed to upload selected category", Toast.LENGTH_SHORT).show();

                    }
                });
    }


    private void saveImageUrlToDatabase(String imageUrl) {
    }
}