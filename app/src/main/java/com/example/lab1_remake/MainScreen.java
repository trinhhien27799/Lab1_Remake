package com.example.lab1_remake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void goToB1(View view) {
        startActivity(new Intent(MainScreen.this, MainActivity.class));
    }

    public void goToB2(View view) {
        startActivity(new Intent(MainScreen.this, B2.class));
    }

    public void goToB3(View view) {
        startActivity(new Intent(MainScreen.this, B3.class));
    }

    public void goToB4(View view) {
        startActivity(new Intent(MainScreen.this, B4.class));
    }
}