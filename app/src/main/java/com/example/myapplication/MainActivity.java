package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void pakar(View view) {
        Intent intent = new Intent(MainActivity.this, Pakar.class);
        startActivity(intent);
    }

    public void bfs(View view) {
        Intent intent = new Intent(MainActivity.this, Bfs.class);
        startActivity(intent);
    }

    public void login(View view) {
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }
}