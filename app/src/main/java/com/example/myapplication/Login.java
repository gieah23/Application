package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void daftar(View view) {
        Intent intent = new Intent(Login.this, Daftar.class);
        startActivity(intent);
    }

    public void login(View view) {
        Intent intent = new Intent(Login.this, Admin.class);
        startActivity(intent);
    }
}