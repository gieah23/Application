package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.firebase.firestore.FirebaseFirestore;

public class TambahArtikel extends AppCompatActivity {

    private Button submitArtikel ;
    private EditText isiDeskripsi,isiPH;
    private ImageView inputGambar ;
    private ProgressBar progressBar ;
    private Uri imageUri ;
    FirebaseFirestore db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_artikel);

        submitArtikel = findViewById(R.id.submitArtikel);
        isiDeskripsi = findViewById(R.id.isiDeskripsi);
        isiPH = findViewById(R.id.isiPH);
        inputGambar = findViewById(R.id.inputGambar);
        progressBar = findViewById(R.id.progresBar);
        progressBar.setVisibility(View.VISIBLE);

        db = FirebaseFirestore.getInstance();


        inputGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,2);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==2 && resultCode == RESULT_OK && data != null){

            imageUri = data.getData();
            inputGambar.setImageURI(imageUri);
    }
}
}